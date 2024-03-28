package com.github.xavierdpt.xddbg.classes.ui.notready;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;

public class CustomCellRenderer implements TableCellRenderer {

    private final JPanel component = new JPanel(new BorderLayout());

    private final JLabel label = new JLabel("");
    private final JButton removeButton = new JButton("X");

    private Font defaultLabelFont;
    private Font boldLabelFont;

    {
        removeButton.setBorder(BorderFactory.createEmptyBorder(4,8,4,8));
        component.add(label, BorderLayout.WEST);
        component.add(removeButton, BorderLayout.EAST);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (defaultLabelFont == null) {
            defaultLabelFont = label.getFont();
            boldLabelFont = defaultLabelFont.deriveFont(Font.BOLD);
        }
        label.setFont(isSelected ? boldLabelFont : defaultLabelFont);
        label.setText(String.valueOf(value));
        return component;
    }
}
