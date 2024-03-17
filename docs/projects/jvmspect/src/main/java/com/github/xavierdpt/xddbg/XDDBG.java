package com.github.xavierdpt.xddbg;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.attributes.code.Instruction;
import com.github.xavierdpt.jvmspect.input.attributes.code.InstructionDataInput;
import com.github.xavierdpt.jvmspect.input.constants.Constant;
import com.github.xavierdpt.jvmspect.input.constants.ConstantDataInput;
import com.github.xavierdpt.xddbg.bytecode.XBytecode;
import com.github.xavierdpt.xddbg.classes.TreeClasses;
import com.github.xavierdpt.xddbg.classes.ClassUO;
import com.github.xavierdpt.xddbg.classes.XClasses;
import com.github.xavierdpt.xddbg.debug.DebugAccessor;
import com.github.xavierdpt.xddbg.methods.TreeMethods;
import com.github.xavierdpt.xddbg.methods.XMethods;
import com.github.xavierdpt.xddbg.tree.BasicUO;
import com.github.xavierdpt.xddbg.tree.BetterTreeNode;
import com.github.xavierdpt.xddbg.utils.ExceptionHelper;
import com.sun.jdi.Method;
import com.sun.jdi.ReferenceType;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.tree.TreeNode;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.function.BiConsumer;

public class XDDBG extends JFrame {

    private final DebugAccessor debugAccessor = new DebugAccessor();
    private final XClasses xClasses;
    private final XMethods xMethods;
    private final JTextArea logs;
    private final XBytecode xBytecode;

    public XDDBG() {
        setTitle("XDDBG");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (debugAccessor.isAttached()) {
                    debugAccessor.detach();
                }
            }
        });


        JTextField portField = new JTextField(6);
        portField.setText("8787");
        JButton button = new JButton("Attach");

        logs = new JTextArea();
        logs.setEditable(false);

        BiConsumer<Boolean, XDBGState> enableManager = (e, newState) -> {
            boolean enabled = Boolean.TRUE.equals(e);
            button.setEnabled(enabled);
            switch (newState) {
                case ATTACH -> portField.setEnabled(enabled);
                case DETACH -> portField.setEnabled(false);
                default -> throw new IllegalStateException("Unexpected state: " + newState);
            }
            switch (newState) {
                case ATTACH -> button.setText("Attach");
                case DETACH -> button.setText("Detach");
            }
        };

        button.addActionListener(e -> {
            if (!debugAccessor.isAttached()) {
                enableManager.accept(false, XDBGState.ATTACH);
                logLine("Attaching...");
                try {
                    debugAccessor.attach(portField.getText(),
                            virtualMachine -> TreeClasses.fillTree(getClassTree(), virtualMachine.allClasses()),
                            (event, vm) -> {
                            });
                } catch (Exception ex) {
                    logException(ex);
                }
                if (debugAccessor.isAttached()) {
                    logLine("Attached");
                    enableManager.accept(true, XDBGState.DETACH);
                } else {
                    logLine("Not Attached");
                    enableManager.accept(true, XDBGState.ATTACH);
                }
            } else {
                enableManager.accept(false, XDBGState.DETACH);
                try {
                    logLine("Detaching...");
                    debugAccessor.detach();
                    TreeHelper.clearTree(getClassTree());
                } finally {
                    if (!debugAccessor.isAttached()) {
                        logLine("Detached.");
                        enableManager.accept(true, XDBGState.ATTACH);
                    } else {
                        logLine("Not detached.");
                        enableManager.accept(false, XDBGState.DETACH);
                    }
                }
            }
        });

        JPanel rootPanel = new JPanel(new BorderLayout());
        JPanel northComponent = new JPanel(new FlowLayout(FlowLayout.LEADING));
        northComponent.add(new JLabel("Remote port"));
        northComponent.add(portField);
        northComponent.add(button);

        xClasses = new XClasses(this);
        xMethods = new XMethods(this);
        xBytecode = new XBytecode(this);

        JSplitPane centerComponent = split(JSplitPane.VERTICAL_SPLIT,
                split(JSplitPane.HORIZONTAL_SPLIT,
                        split(JSplitPane.HORIZONTAL_SPLIT,
                                xClasses,
                                xMethods
                        ),
                        xBytecode
                ),
                logs
        );

        rootPanel.add(northComponent, BorderLayout.NORTH);
        rootPanel.add(centerComponent, BorderLayout.CENTER);
        add(rootPanel);
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }

    private JSplitPane split(int orientation, Component placeholderTree, Component classPanelLayout) {
        JSplitPane splitPane = new JSplitPane(orientation, placeholderTree, classPanelLayout);
        splitPane.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                splitPane.setDividerLocation(.5D);
                //splitPane.removeComponentListener(this);
            }
        });
        return splitPane;
    }

    public void logLine(String line) {
        if (logs == null) {
            System.out.println(line);
        } else {
            logs.append(line + "\n");
        }
    }

    public void logException(Exception ex) {
        if (logs == null) {
            System.out.print(ExceptionHelper.toMultilineString(ex));
        } else {
            logs.append(ExceptionHelper.toMultilineString(ex));
        }
    }


    public JTree getClassTree() {
        return xClasses.getTree();
    }

    public void findMethods() {
        if (debugAccessor.isAttached()) {
            Object lastSelectedPathComponent = getClassTree().getLastSelectedPathComponent();
            if (lastSelectedPathComponent instanceof BetterTreeNode betterNode) {
                Object userObject = betterNode.getUserObject();
                if (userObject instanceof ClassUO leafClassUO) {
                    String referenceName = leafClassUO.getFullName();
                    debugAccessor.accessVm(virtualMachine -> {
                        List<ReferenceType> referenceTypes = virtualMachine.classesByName(referenceName);
                        if (referenceTypes.isEmpty()) {
                            logLine("Reference not found: " + referenceName);
                        } else {
                            if (referenceTypes.size() > 1) {
                                logLine("WARNING: Found mutiple references for " + referenceName + "; using the first one");
                            }
                            ReferenceType referenceType = referenceTypes.get(0);
                            TreeHelper.clearTree(xMethods.getTree());
                            HashSet<Method> visibleMethods = new HashSet<>(referenceType.visibleMethods());
                            for (Method method : referenceType.allMethods()) {
                                ReferenceType declaringType = method.declaringType();
                                boolean visible = visibleMethods.contains(method);
                                TreeMethods.fillMethodTree(xMethods.getTree(), declaringType.name(), method.name(), method.signature(), visible);
                            }
                        }
                        return null;
                    });
                }
            }
        }
    }


    public void showBytecode() {
        xBytecode.show(findBytecode());
    }

    public InstructionsWithResolver findBytecode() {
        Object signaturePC = getMethodTree().getLastSelectedPathComponent();
        if (signaturePC instanceof BetterTreeNode signatureBTN) {
            if (signatureBTN.isLeaf()) {
                Object signatureUO = signatureBTN.getUserObject();
                if (signatureUO instanceof BasicUO signatureBUO) {
                    String signature = signatureBUO.getName();
                    TreeNode methodTN = signatureBTN.getParent();
                    if (methodTN instanceof BetterTreeNode methodBTN) {
                        Object methodUO = methodBTN.getUserObject();
                        if (methodUO instanceof BasicUO methodBUO) {
                            String methodName = methodBUO.getName();
                            TreeNode classTN = methodTN.getParent();
                            if (classTN instanceof BetterTreeNode classBTN2) {
                                Object classUO = classBTN2.getUserObject();
                                if (classUO instanceof BasicUO classBUO) {
                                    String className = classBUO.getName();
                                    return findBytecode(className, methodName, signature);
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    private InstructionsWithResolver findBytecode(String className, String methodName, String methodSignature) {
        if (debugAccessor.isAttached()) {
            return debugAccessor.accessVm(vm -> {
                List<ReferenceType> classes = vm.classesByName(className);
                if (classes.isEmpty()) {
                    logLine("Not found: " + className);
                } else {
                    if (classes.size() > 1) {
                        logLine("WARNING: Found " + classes.size() + " classes named '" + className + "' ; using the first one");
                    }
                    ReferenceType clazz = classes.get(0);
                    int minorVersion = clazz.minorVersion();
                    int majorVersion = clazz.majorVersion();
                    ConstantResolver constantResolver;
                    if (vm.canGetConstantPool()) {
                        int constantPoolCount = clazz.constantPoolCount();
                        byte[] constantPoolBytes = clazz.constantPool();
                        try {
                            Constant[] constants = ConstantDataInput.readAll(constantPoolBytes, constantPoolCount - 1);
                            constantResolver = new ConstantResolver(constants);
                        } catch (IOException e) {
                            logException(e);
                            constantResolver = new ConstantResolver(new Constant[0]);
                        }
                    } else {
                        constantResolver = new ConstantResolver(new Constant[0]);
                    }
                    try {
                        List<Method> methods = clazz.methodsByName(methodName, methodSignature);
                        if (methods.isEmpty()) {
                            logLine("Method not found: " + methodName + "(" + methodSignature + ")");
                        } else {
                            if (methods.size() > 1) {
                                logLine("WARNING: Found " + methods.size() + " methods named '" + methodName + "' with signature '" + methodSignature + "'; using the first one");
                            }
                            Method method = methods.get(0);
                            byte[] bytecodes = method.bytecodes();
                            List<Instruction> instructions = InstructionDataInput.parse(bytecodes, 0, -1);
                            return new InstructionsWithResolver(instructions, constantResolver);
                        }

                    } catch (IOException e) {
                        logException(e);
                    }

                }
                return null;
            });
        }
        return null;
    }

    private JTree getMethodTree() {
        return xMethods.getTree();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        JFrame.setDefaultLookAndFeelDecorated(true);
        SwingUtilities.invokeLater(() -> {
            XDDBG processOutputPoller = new XDDBG();
            processOutputPoller.setVisible(true);
        });
    }
}
