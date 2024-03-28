package com.github.xavierdpt.xddbg.classes.ui;

import javax.swing.table.DefaultTableModel;

public class CustomTableModel extends DefaultTableModel {
    public CustomTableModel() {
        super(new Object[0][0], new String[]{"."});

    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return column == 0;
    }
}
