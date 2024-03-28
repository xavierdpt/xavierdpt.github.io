package com.github.xavierdpt.xddbg.discovery2;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.basic.BasicComboPopup;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Discovery5 extends JFrame {

    public Discovery5() throws HeadlessException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button1 = new JButton("Button1");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BasicComboPopup(null);
            }
        });
        JButton button2 = new JButton("Button2");
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(button1, BorderLayout.WEST);
        panel.add(button2, BorderLayout.EAST);
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
            Discovery5 app = new Discovery5();
            app.setVisible(true);
        });
    }
}

