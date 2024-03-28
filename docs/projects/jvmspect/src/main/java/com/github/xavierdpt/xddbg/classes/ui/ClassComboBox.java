package com.github.xavierdpt.xddbg.classes.ui;

import com.github.xavierdpt.xddbg.classes.ui.notready.BetterComboBox;
import com.github.xavierdpt.xddbg.classes.ui.notready.CustomCellEditor;
import com.github.xavierdpt.xddbg.classes.ui.notready.CustomCellRenderer;
import com.github.xavierdpt.xddbg.utils.SwingHelper;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClassComboBox extends BetterComboBox<String, JTextField, JTable> {

    private final List<Runnable> actionListeners = new ArrayList<>();

    public ClassComboBox(JFrame owner) {
        super(new JTextField(), new JTable(new CustomTableModel()), owner);
        mainComponent.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int modifiers = e.getModifiersEx();
                int keyCode = e.getExtendedKeyCode();
                if ((modifiers & InputEvent.ALT_DOWN_MASK) > 0) {
                    if (keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_KP_DOWN) {
                        showPopup();
                    }
                } else if (keyCode == KeyEvent.VK_ENTER) {
                    actionListeners.forEach(Runnable::run);
                }
            }
        });

        itemListComponent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        itemListComponent.setShowGrid(false);
        itemListComponent.setFillsViewportHeight(true);
        itemListComponent.setTableHeader(null);
        itemListComponent.getColumnModel().getColumn(0).setCellRenderer(new CustomCellRenderer());
        itemListComponent.getColumnModel().getColumn(0).setCellEditor(new CustomCellEditor());


        //itemListComponent.setCellRenderer(new ClassComboListCellRenderer(itemListComponent.getCellRenderer()));

        registerEscape(() -> Collections.singletonList(super.itemListComponent));
    }

    @Override
    public void setCurrentItem(String item) {
        mainComponent.setText(item);
    }

    @Override
    public String getCurrentItem() {
        return mainComponent.getText();
    }

    @Override
    public void addItem(String item) {
        if (itemListComponent.getModel() instanceof DefaultTableModel model) {
            model.addRow(new String[]{item});
        }
    }

    @Override
    public void removeItem(String item) {
        if (itemListComponent.getModel() instanceof DefaultTableModel model) {
            int rowIndex = -1;
            for (int row = 0; row < model.getRowCount(); row++) {
                Object value = model.getValueAt(row, 0);
                if (value instanceof String string && value.equals(item)) {
                    rowIndex = row;
                    break;
                }
            }
            if (rowIndex > 0) {
                model.removeRow(rowIndex);
            }
        }
    }


    @Override
    public String getItemAt(int index) {
        if (itemListComponent.getModel() instanceof DefaultTableModel model) {
            if (model.getValueAt(index, 0) instanceof String string) {
                return string;
            }
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return itemListComponent.getRowCount();
    }

    @Override
    public void clearItems() {
        if (itemListComponent.getModel() instanceof DefaultTableModel model) {
            model.setRowCount(0);
        }
    }

    public void setFirst(String item) {
        removeItem(item);
        insertAt(0, item);
    }

    @Override
    public void insertAt(int index, String item) {
        if (itemListComponent.getModel() instanceof DefaultTableModel model) {
            model.insertRow(index, new String[]{item});
        }
    }

    public void addActionListener(Runnable actionListener) {
        actionListeners.add(actionListener);
    }

    @Override
    protected Component wrapItemListComponent(Dimension minimumSize, Dimension maximumSize) {
        JScrollPane scrollPane = SwingHelper.inScrollPane(itemListComponent);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        addPopupShownListener(() -> {
            Dimension size = itemListComponent.getSize();
            size = new Dimension(
                    Math.max(Math.min(size.width, maximumSize.width), minimumSize.width),
                    Math.max(Math.min(size.height, maximumSize.height), minimumSize.height)
            );
            scrollPane.setMinimumSize(size);
            scrollPane.setPreferredSize(size);
            scrollPane.setMaximumSize(size);
        });
        return scrollPane;
    }


}
