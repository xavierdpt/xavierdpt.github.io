package com.github.xavierdpt.jvmspect;

import com.github.xavierdpt.jvmspect.basex.BaseXHelper;
import com.github.xavierdpt.jvmspect.basex.BaseXSession;
import com.github.xavierdpt.jvmspect.utils.FileHelper;
import com.github.xavierdpt.jvmspect.workflow.ui.ActionRunner;
import org.basex.BaseXGUI;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.xml.transform.TransformerException;
import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JVMSpect extends JFrame {

    public JVMSpect() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel centerPanel = new JPanel();
        JCheckBox forceUnpack = new JCheckBox("Force");
        JCheckBox unpack = new JCheckBox("Unpack .class files");
        JCheckBox forceDump = new JCheckBox("Force");
        JCheckBox dump = new JCheckBox("Dump .class files to XML");
        JCheckBox forceImport = new JCheckBox("Force");
        JCheckBox importcb = new JCheckBox("Import .class files to database");
        JCheckBox generateStats = new JCheckBox("Generate stats");

        centerPanel.add(forceUnpack);
        centerPanel.add(unpack);
        centerPanel.add(forceDump);
        centerPanel.add(dump);
        centerPanel.add(forceImport);
        centerPanel.add(importcb);
        centerPanel.add(generateStats);
        JButton runActions = new JButton("Run actions");

        List<Runnable> disable = new ArrayList<>();
        List<Runnable> enable = new ArrayList<>();


        runActions.addActionListener(e -> {
            disable.forEach(Runnable::run);
            new Thread(() -> {
                try {
                    if (unpack.isSelected()) {
                        ActionRunner.doUnpack(forceUnpack.isSelected());
                    }
                    if (dump.isSelected()) {
                        ActionRunner.doDump(forceDump.isSelected());
                    }

                    if (importcb.isSelected() || generateStats.isSelected()) {
                        try (BaseXSession baseXSession = BaseXHelper.startServer()) {
                            if (importcb.isSelected()) {
                                ActionRunner.doImport(forceImport.isSelected(), baseXSession);
                            }
                            if (generateStats.isSelected()) {
                                ActionRunner.doGenerateCharts(baseXSession);
                            }
                        }
                    }


                } catch (IOException | InterruptedException | TransformerException ex) {
                    throw new RuntimeException(ex);
                } finally {
                    enable.forEach(Runnable::run);
                }
            }).start();
        });
        centerPanel.add(runActions);
        JButton baseXGui = new JButton("BaseX GUI");
        baseXGui.addActionListener(e -> {
            Thread thread = new Thread(() -> {
                disable.forEach(Runnable::run);
                try {
                    FileHelper.ensureDir(JVMSpectConstants.LOCAL_DIR);
                    System.setProperty("org.basex.path", new File(JVMSpectConstants.LOCAL_DIR, "basexhome").getAbsolutePath());
                    BaseXGUI.main();
                } finally {
                    enable.forEach(Runnable::run);
                }
            });
            thread.setDaemon(false);
            thread.start();
        });
        centerPanel.add(baseXGui);
        disable.add(() -> {
            runActions.setEnabled(false);
            baseXGui.setEnabled(false);
        });
        enable.add(() -> {
            runActions.setEnabled(true);
            baseXGui.setEnabled(true);
        });
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        add(mainPanel);
        pack();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        JFrame.setDefaultLookAndFeelDecorated(true);
        SwingUtilities.invokeLater(() -> {
            JVMSpect application = new JVMSpect();
            application.setVisible(true);
        });
    }
}
