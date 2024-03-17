package com.github.xavierdpt.xddbg.methods;

import com.github.xavierdpt.xddbg.XDDBG;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;

public class XMethodSearchBox extends JPanel {
    public XMethodSearchBox(XDDBG app) {
        super(new BorderLayout());
        JTextField searchInput = new JTextField(50);
        JButton searchButton = new JButton("search");

        searchButton.addActionListener(e -> {
            app.logLine("TODO");
        });

        add(new JLabel("Filter methods"), BorderLayout.WEST);
        add(searchInput, BorderLayout.CENTER);
        add(searchButton, BorderLayout.EAST);
    }

}
