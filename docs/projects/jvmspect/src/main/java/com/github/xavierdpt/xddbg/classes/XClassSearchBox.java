package com.github.xavierdpt.xddbg.classes;

import com.github.xavierdpt.xddbg.XDDBG;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import java.awt.BorderLayout;

public class XClassSearchBox extends JPanel {


    public XClassSearchBox(XDDBG app) {
        super(new BorderLayout());
        JTextField searchInput = new JTextField(50);
        JButton searchButton = new JButton("search");

        searchButton.addActionListener(e -> {
            TreeModel model = app.getClassTree().getModel();
            if (model instanceof DefaultTreeModel defaultTreeModel) {
                String searchText = searchInput.getText();
                ClassSearchFilter.filter(defaultTreeModel, searchText);
            }
        });

        add(new JLabel("Filter classes"), BorderLayout.WEST);
        add(searchInput, BorderLayout.CENTER);
        add(searchButton, BorderLayout.EAST);
    }

}
