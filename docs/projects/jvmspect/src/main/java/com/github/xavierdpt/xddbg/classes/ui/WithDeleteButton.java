package com.github.xavierdpt.xddbg.classes.ui;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import java.awt.BorderLayout;
import java.awt.Component;

public class WithDeleteButton implements ListCellRenderer<String> {

    private final ListCellRenderer<? super String> renderer;
    private JPanel panel = new JPanel(new BorderLayout());

    private JButton button = new JButton("X");

    private Component childComponent;
    {
        if (false) {
            // TOOD: make button interactive and fix scrollbar issue
            panel.add(button,BorderLayout.EAST);
            button.setBorderPainted(false);
        }
    }

    public WithDeleteButton(ListCellRenderer<? super String> renderer) {
        this.renderer = renderer;
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends String> list, String value, int index, boolean isSelected, boolean cellHasFocus) {
        if (isSelected) {
            System.out.println("selected");
        }
        if(childComponent == null) {
            childComponent = renderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            panel.add(childComponent,BorderLayout.CENTER);
        } else {
            childComponent = renderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        }
        return panel;
    }
}
