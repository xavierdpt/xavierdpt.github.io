package com.github.xavierdpt.xddbg.discovery2;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeListener;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
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

public class Discovery2 extends JFrame {

    public Discovery2() throws HeadlessException {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button1 = new JButton("Reset");


        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        comboBoxModel.addElement("Element 1");
        comboBoxModel.addElement("Element 2");
        comboBoxModel.addElement("Element 3");
        JComboBox<String> comboBox = new JComboBox<>(comboBoxModel);
        comboBox.setEditable(true);
        comboBox.getEditor().setItem("New element");
        comboBox.setRenderer(new ListCellRenderer<String>() {

            private final JButton button = new JButton("");

            private final Font normalFont;

            private final Font boldFont;

            {
                normalFont = button.getFont();
                boldFont = normalFont.deriveFont(Font.BOLD);
                button.addActionListener(VerboseProxy.createVerboseProxy(ActionListener.class, this.getClass().getClassLoader()));
                button.addAncestorListener(VerboseProxy.createVerboseProxy(AncestorListener.class, this.getClass().getClassLoader()));
                button.addChangeListener(VerboseProxy.createVerboseProxy(ChangeListener.class, this.getClass().getClassLoader()));
                button.addComponentListener(VerboseProxy.createVerboseProxy(ComponentListener.class, this.getClass().getClassLoader()));
                button.addContainerListener(VerboseProxy.createVerboseProxy(ContainerListener.class, this.getClass().getClassLoader()));
                button.addFocusListener(VerboseProxy.createVerboseProxy(FocusListener.class, this.getClass().getClassLoader()));
                button.addHierarchyBoundsListener(VerboseProxy.createVerboseProxy(HierarchyBoundsListener.class, this.getClass().getClassLoader()));
                button.addHierarchyListener(VerboseProxy.createVerboseProxy(HierarchyListener.class, this.getClass().getClassLoader()));
                button.addInputMethodListener(VerboseProxy.createVerboseProxy(InputMethodListener.class, this.getClass().getClassLoader()));
                button.addItemListener(VerboseProxy.createVerboseProxy(ItemListener.class, this.getClass().getClassLoader()));
                button.addKeyListener(VerboseProxy.createVerboseProxy(KeyListener.class, this.getClass().getClassLoader()));
                button.addMouseListener(VerboseProxy.createVerboseProxy(MouseListener.class, this.getClass().getClassLoader()));
                button.addMouseMotionListener(VerboseProxy.createVerboseProxy(MouseMotionListener.class, this.getClass().getClassLoader()));
                button.addMouseWheelListener(VerboseProxy.createVerboseProxy(MouseWheelListener.class, this.getClass().getClassLoader()));
                button.addPropertyChangeListener(VerboseProxy.createVerboseProxy(PropertyChangeListener.class, this.getClass().getClassLoader()));
            }

            @Override
            public Component getListCellRendererComponent(JList<? extends String> list, String value, int index, boolean isSelected, boolean cellHasFocus) {
                button.setText(value);
                button.setForeground(isSelected ? Color.RED : Color.GRAY);
                button.setFont(cellHasFocus ? boldFont : normalFont);
                if (isSelected) {
                    button.requestFocusInWindow();
                }
                return button;
            }
        });


        comboBox.addPopupMenuListener(new PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                System.out.println("visible");
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                System.out.println("invisible");
            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {
                System.out.println("canceled");
            }
        });

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
            Discovery2 app = new Discovery2();
            app.setVisible(true);
        });
    }
}

