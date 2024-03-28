package com.github.xavierdpt.xddbg.discovery2;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeListener;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.plaf.basic.BasicComboPopup;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerListener;
import java.awt.event.FocusListener;
import java.awt.event.HierarchyBoundsListener;
import java.awt.event.HierarchyListener;
import java.awt.event.InputMethodListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;
import java.beans.PropertyChangeListener;

public class Discovery6 extends JFrame {

    public Discovery6() throws HeadlessException {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button1 = new JButton("Reset");


        DefaultComboBoxModel<Object> comboBoxModel = new DefaultComboBoxModel<>();
        comboBoxModel.addElement("Element 1");
        comboBoxModel.addElement("Element 2");
        comboBoxModel.addElement("Element 3");
        JComboBox<Object> comboBox = new JComboBox<>(comboBoxModel) {

            private final BasicComboPopup popup = new BasicComboPopup(this);

            @Override
            public void setPopupVisible(boolean v) {
                popup.setVisible(v);
            }

            @Override
            public boolean isPopupVisible() {
                return popup.isVisible();
            }
        };
        comboBox.setEditable(true);
        comboBox.getEditor().setItem("New element");


        JButton button2 = new JButton("Button 2");
        button2.addActionListener(e -> System.out.println("Button2 clicked"));

        button1.addActionListener(e -> {
            comboBox.getEditor().setItem("New element");
        });

        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(button1);
        topPanel.add(button2);


        JPanel panel = new JPanel(new BorderLayout());
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(comboBox, BorderLayout.CENTER);
        add(panel);
        pack();
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
            Discovery6 app = new Discovery6();
            app.setVisible(true);
        });
    }
}

