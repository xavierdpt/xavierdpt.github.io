package com.github.xavierdpt.xddbg.discovery2;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.BorderLayout;
import java.awt.HeadlessException;

public class Discovery4 extends JFrame {

    public Discovery4() throws HeadlessException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("Click me");
        button.addActionListener(e -> {
            JDialog window = new JDialog(Discovery4.this, true);
            JPanel panel = new JPanel(new BorderLayout());
            JButton closeWindowButton = new JButton("Close window");
            closeWindowButton.addActionListener(e1 -> window.dispose());
            panel.add(closeWindowButton);
            window.add(panel);
            window.pack();
            window.setVisible(true);
        });
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(button, BorderLayout.CENTER);
        add(panel);
        pack();
        setLocation(100,100);
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
            Discovery4 app = new Discovery4();
            app.setVisible(true);
        });
    }
}

