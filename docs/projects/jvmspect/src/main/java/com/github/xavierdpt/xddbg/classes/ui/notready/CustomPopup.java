package com.github.xavierdpt.xddbg.classes.ui.notready;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CustomPopup extends JDialog {

    public CustomPopup(JFrame owner, Component component, Dimension minimumSize, Dimension maximumSize) {
        super(owner, false);
        setType(Window.Type.POPUP);
        setUndecorated(true);
        JPanel panel = new JPanel(new BorderLayout());
        setMaximumSize(maximumSize);
        setMinimumSize(minimumSize);
        panel.setMinimumSize(minimumSize);
        panel.setMaximumSize(maximumSize);
        panel.setBorder(BorderFactory.createTitledBorder("Items"));
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        panel.add(component, BorderLayout.CENTER);
        add(panel);
        pack();
    }

    public void registerEscape(Component component) {
        component.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getExtendedKeyCode() == KeyEvent.VK_ESCAPE) {
                    dispose();
                }
                if (e.getExtendedKeyCode() == KeyEvent.VK_TAB) {
                    if (e.getSource() instanceof JTable table) {
                        e.consume();
                        if (table.isEditing()) {

                            if (table.getEditorComponent() instanceof Container container) {
                                // TODO: implement this recursively
                                boolean focusNext = false;
                                for (int i = 0; i < container.getComponentCount(); i++) {
                                    Component component = container.getComponent(i);
                                    if (component.hasFocus()) {
                                        focusNext = true;
                                    } else if (focusNext) {
                                        component.requestFocusInWindow();
                                        break;
                                    }
                                }
                                if (!focusNext) {
                                    if (container.getComponentCount() > 0) {
                                        container.getComponent(0).requestFocusInWindow();
                                    }
                                }
                            }


                        } else {
                            table.editCellAt(table.getSelectedRow(), 0);
                        }
                    }

                }
            }
        });
    }
}
