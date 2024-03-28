package com.github.xavierdpt.xddbg;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.attributes.code.Instruction;
import com.github.xavierdpt.jvmspect.input.attributes.code.InstructionDataInput;
import com.github.xavierdpt.jvmspect.input.constants.Constant;
import com.github.xavierdpt.jvmspect.input.constants.ConstantDataInput;
import com.github.xavierdpt.jvmspect.utils.JSON;
import com.github.xavierdpt.xddbg.bytecode.XBytecode;
import com.github.xavierdpt.xddbg.classes.misc.ClassUO;
import com.github.xavierdpt.xddbg.classes.misc.TreeClasses;
import com.github.xavierdpt.xddbg.classes.ui.ClassPanel;
import com.github.xavierdpt.xddbg.debug.DebugAccessor;
import com.github.xavierdpt.xddbg.methods.misc.TreeMethods;
import com.github.xavierdpt.xddbg.methods.ui.MethodsPanel;
import com.github.xavierdpt.xddbg.tree.BasicUO;
import com.github.xavierdpt.xddbg.tree.BetterTreeNode;
import com.github.xavierdpt.xddbg.tree.TreeModelManager;
import com.github.xavierdpt.xddbg.utils.ExceptionHelper;
import com.github.xavierdpt.xddbg.utils.SwingHelper;
import com.github.xavierdpt.xddbg.utils.VMHelper;
import com.sun.jdi.AbsentInformationException;
import com.sun.jdi.Location;
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
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.BiConsumer;

public class XDDBG extends JFrame {

    private final DebugAccessor debugAccessor = new DebugAccessor();
    private final ClassPanel classPanel;
    private final MethodsPanel methodsPanel;
    private final JTextArea logs;
    private final XBytecode xBytecode;
    private final JTextField portField;
    public final Config config = new Config();


    private String lastBadClass = null;

    public XDDBG() {
        setTitle("XDDBG");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (debugAccessor.isAttached()) {
                    debugAccessor.detach();
                }
                try {
                    ConfigManager.saveConfig(XDDBG.this);
                } catch (IOException ex) {
                    System.err.print(ExceptionHelper.toMultilineString(ex));
                }
            }
        });


        portField = new JTextField(6);
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
                    debugAccessor.attach(
                            portField.getText(),
                            virtualMachine -> TreeClasses.fillTree(getClassTree(), virtualMachine.allClasses(), this),
                            new VMEventHandler(this));
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

        classPanel = new ClassPanel(this);
        methodsPanel = new MethodsPanel(this);
        xBytecode = new XBytecode(this);

        JSplitPane centerComponent = SwingHelper.split(JSplitPane.VERTICAL_SPLIT,
                SwingHelper.split(JSplitPane.HORIZONTAL_SPLIT,
                        SwingHelper.split(JSplitPane.HORIZONTAL_SPLIT,
                                classPanel,
                                methodsPanel
                        ),
                        xBytecode
                ),
                SwingHelper.inScrollPane(logs)
        );

        rootPanel.add(northComponent, BorderLayout.NORTH);
        rootPanel.add(centerComponent, BorderLayout.CENTER);


        add(rootPanel);
        pack();
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);

        try {
            JsonNode json = ConfigManager.readConfig(config);
            config.setPort(JSON.getString(json, "port", ""));
            config.setClassSearch(JSON.getString(json, "classSearch", ""));
        } catch (IOException e) {
            logException(e);
        }
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
                            TreeHelper.clearTree(methodsPanel.getTree());
                            HashSet<Method> visibleMethods = new HashSet<>(referenceType.visibleMethods());
                            for (Method method : referenceType.allMethods()) {
                                boolean empty = true;
                                if (virtualMachine.canGetBytecodes()) {
                                    empty = method.bytecodes().length == 0;
                                }
                                ReferenceType declaringType = method.declaringType();
                                boolean visible = visibleMethods.contains(method);
                                TreeMethods.fillMethodTree(methodsPanel.getTree(), declaringType.name(), method.name(), method.signature(), visible, empty);
                            }
                            methodsPanel.filterMethods();
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
                    ConstantResolver constantResolver;
                    if (vm.canGetConstantPool()) {
                        int constantPoolCount = clazz.constantPoolCount();
                        byte[] constantPoolBytes = clazz.constantPool();
                        try {
                            Constant[] constants = ConstantDataInput.readAll(constantPoolBytes, constantPoolCount-1);
                            constantResolver = new ConstantResolver(constants);
                        } catch (Exception e) {
                            logException(e);
                            if (!className.equals(lastBadClass)) {
                                lastBadClass = className;
                                File dumpFile = new File(XDDBGConstants.XDDBG_LOCAL_DIR, "badconstantpool.bytes");
                                boolean writeDumpFile = true;
                                if (dumpFile.exists()) {
                                    if (dumpFile.isDirectory()) {
                                        logLine("Dump file is a directory: " + dumpFile.getAbsolutePath());
                                        writeDumpFile = false;
                                    } else {
                                        long length = dumpFile.length();
                                        if (constantPoolBytes.length >= length) {
                                            writeDumpFile = false;
                                        }
                                    }
                                }
                                if (writeDumpFile) {
                                    logLine("Dumping bad constant pool (" + constantPoolBytes.length + " bytes) into " + dumpFile.getAbsolutePath());
                                    try (FileOutputStream fos = new FileOutputStream(dumpFile)) {
                                        fos.write((className + "\n").getBytes());
                                        fos.write(constantPoolBytes);
                                    } catch (IOException exception) {
                                        logException(exception);
                                    }

                                }

                            }
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
                            List<Location> locations;
                            try {
                                locations = method.allLineLocations();
                            } catch (AbsentInformationException e) {
                                locations = new ArrayList<>();
                            }
                            LineNumbers lineNumbers = LineNumbers.of(locations);
                            List<Instruction> instructions = InstructionDataInput.parse(bytecodes, 0, -1);
                            return new InstructionsWithResolver(instructions, constantResolver, lineNumbers);
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

    public void setBreakpoint() {
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
                                    setBreakpoint(signature, methodName, className);
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    private void setBreakpoint(String signature, String methodName, String className) {
        if (debugAccessor.isAttached()) {
            debugAccessor.accessVm(vm -> {
                List<ReferenceType> classes = vm.classesByName(className);
                if (classes.isEmpty()) {
                    logLine("Not found: " + className);
                } else {
                    if (classes.size() > 1) {
                        logLine("WARNING: Found " + classes.size() + " classes named '" + className + "' ; using the first one");
                    }
                    var clazz = classes.get(0);
                    var methods = clazz.methodsByName(methodName, signature);
                    if (methods.isEmpty()) {
                        logLine("Method not found: " + methodName + "(" + signature + ")");
                    } else {
                        if (methods.size() > 1) {
                            logLine("WARNING: Found " + methods.size() + " methods named '" + methodName + "' with signature '" + signature + "'; using the first one");
                        }
                        var method = methods.get(0);
                        if (method.isBridge()) {
                            logLine("Can't set breakpoint, this method is a bridge");
                        } else if (method.isNative()) {
                            logLine("Cant' set breakpoint, this method is native");
                        } else if (method.isAbstract()) {
                            logLine("Cant' set breakpoint, this method is abstract");
                        } else {
                            var bytecodes = method.bytecodes();
                            if (bytecodes.length == 0) {
                                logLine("Cant' set breakpoint, this method is empty");
                            } else {
                                Location location = method.locationOfCodeIndex(0);
                                if (location == null) {
                                    logLine("Cant' set breakpoint, location of code index 0 not found");
                                } else {
                                    VMHelper.createBreakpoint(vm, location);
                                    logLine("Breakpoint set on " + location);
                                }
                            }
                        }
                        return null;
                    }

                }
                return null;
            });
        }
    }

    public JTree getMethodTree() {
        return methodsPanel.getTree();
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

    public TreeModelManager getClassTreeModelManager() {
        return classPanel.getTreeModelManager();
    }

    public TreeModelManager getMethodTreeModelManager() {
        return methodsPanel.getTreeModelManager();
    }


    class Config {
        public String getPort() {
            return portField.getText();
        }

        public void setPort(String port) {
            portField.setText(port);
        }

        public String getClassSearch() {
            return classPanel.getClassSearchText();
        }

        public void setClassSearch(String classSearch) {
            classPanel.setClassSearch(classSearch);
        }

        public boolean hideEmptyMethods() {
            return methodsPanel.hideEmptyMethods();
        }

        public void setHideEmptyMethods(boolean hideEmptyMethods) {
            methodsPanel.setHideEmptyMethods(hideEmptyMethods);
        }

        public List<String> getClassSearchHistory() {
            return classPanel.getClassSearchHistory();
        }

        public void setClassSearchHistory(List<String> classSearchHistoryItems) {
            classPanel.setClassSearchHistory(classSearchHistoryItems);
        }
    }

    public JTree getClassTree() {
        return classPanel.getTree();
    }

}
