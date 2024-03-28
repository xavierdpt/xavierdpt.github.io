package com.github.xavierdpt.xddbg.classes.ui.notready;

import javax.swing.JComboBox;

public class ComboBoxHelper {
    public static void remember(JComboBox<String> comboBox, String item) {
        Object selectedItem = comboBox.getSelectedItem();
        comboBox.removeItem(item);
        comboBox.insertItemAt(item, 0);
        if (selectedItem != null) {
            comboBox.setSelectedItem(selectedItem);
        }

    }
}
