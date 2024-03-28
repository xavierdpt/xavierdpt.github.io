package com.github.xavierdpt.xddbg.classes.ui.notready;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;
import java.awt.BorderLayout;
import java.awt.Component;
import java.util.EventObject;

public class CustomCellEditor implements TableCellEditor {

    private final JPanel panel = new JPanel(new BorderLayout());
    private final JLabel label = new JLabel("");
    private final JButton removeButton = new JButton("X");

    {
        removeButton.setBorder(BorderFactory.createEmptyBorder(4,8,4,8));
        panel.add(label, BorderLayout.WEST);
        panel.add(removeButton, BorderLayout.EAST);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        label.setText(String.valueOf(value));
        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return "";
    }

    @Override
    public boolean isCellEditable(EventObject anEvent) {
        return true;
    }

    @Override
    public boolean shouldSelectCell(EventObject anEvent) {
        return true;
    }

    @Override
    public boolean stopCellEditing() {
        return false;
    }

    @Override
    public void cancelCellEditing() {

    }

    @Override
    public void addCellEditorListener(CellEditorListener l) {

    }

    @Override
    public void removeCellEditorListener(CellEditorListener l) {

    }
}
