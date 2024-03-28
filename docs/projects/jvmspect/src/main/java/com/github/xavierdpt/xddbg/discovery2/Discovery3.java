package com.github.xavierdpt.xddbg.discovery2;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Discovery3 extends JFrame {

    public Discovery3() throws HeadlessException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("Click me");
        button.addActionListener(e -> {
            JPopupMenu popupMenu = new JPopupMenu("Hello world");
            JPanel popupPanel = new JPanel(new BorderLayout());
            JButton closePopupButton = new JButton("Close popup");
            closePopupButton.addActionListener(e1 -> popupMenu.setVisible(false));
            popupPanel.add(closePopupButton);
            popupMenu.add(popupPanel);
            popupMenu.setVisible(true);
        });
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(button, BorderLayout.CENTER);
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
            Discovery3 app = new Discovery3();
            app.setVisible(true);
        });
    }
}

