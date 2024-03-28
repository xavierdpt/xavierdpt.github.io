package com.github.xavierdpt.xddbg.classes.ui;

import com.github.xavierdpt.xddbg.TreeHelper;
import com.github.xavierdpt.xddbg.XDDBG;
import com.github.xavierdpt.xddbg.classes.misc.ClassSearchFilter;
import com.github.xavierdpt.xddbg.classes.ui.notready.ComboBoxHelper;
import org.apache.commons.lang3.StringUtils;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class ClassSearchPanel extends JPanel {

    private final JComboBox<String> searchInput;

    public ClassSearchPanel(XDDBG app) {
        super(new BorderLayout());
        searchInput = new JComboBox<>(new DefaultComboBoxModel<>());

        searchInput.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
                    filter(app);
                } else if (e.getExtendedKeyCode() == KeyEvent.VK_DELETE && false) {
                    // TODO: Handle delete
                    if ((e.getModifiersEx()) == KeyEvent.VK_CONTROL) {
                        forgetSelected();
                    }
                }
            }
        });
        searchInput.setEditable(true);
        searchInput.setRenderer(new WithDeleteButton(searchInput.getRenderer()));
        // TODO: Fix size issue


        JButton filterButton = new JButton("Filter");
        filterButton.addActionListener(e -> filter(app));
        JButton forgetButton = new JButton("Forget");
        forgetButton.addActionListener(e -> forgetSelected());

        add(new JLabel("Filter classes"), BorderLayout.WEST);
        add(this.searchInput, BorderLayout.CENTER);
        add(filterButton, BorderLayout.EAST);
    }

    private void forgetSelected() {
        if (searchInput.getSelectedItem() instanceof String string) {
            if (StringUtils.isNotBlank(string)) {
                if (searchInput.getModel() instanceof DefaultComboBoxModel<String> model) {
                    model.removeElement(string);
                    if (model.getSize() > 0) {
                        searchInput.setSelectedItem(model.getElementAt(0));
                    }
                }
            }
        }
    }

    private void filter(XDDBG app) {
        String searchText = getSearchInputText();
        ComboBoxHelper.remember(searchInput, searchText);
        ClassSearchFilter classSearchFilter = new ClassSearchFilter();
        classSearchFilter.filter(searchText, app.getClassTreeModelManager(), app.getClassTree());
        if (classSearchFilter.getNumberOfVisibleClasses() != 0) {
            if (classSearchFilter.getNumberOfVisibleClasses() <= 10) {
                TreeHelper.expandAll(app.getClassTree());
            } else {
                TreeHelper.expandFirst(app.getClassTree());
            }
        }
    }

    public void setSearchInputText(String searchInputText) {
        searchInput.getEditor().setItem(searchInputText);
    }

    public String getSearchInputText() {
        return String.valueOf(searchInput.getEditor().getItem());
    }

    public List<String> getClassSearchHistory() {
        int itemCount = searchInput.getItemCount();
        List<String> result = new ArrayList<>(itemCount);
        for (int i = 0; i < itemCount; i++) {
            result.add(searchInput.getItemAt(i));
        }
        return result;
    }

    public void setClassSearchHistory(List<String> classSearchHistoryItems) {
        if (searchInput.getModel() instanceof DefaultComboBoxModel<String> model) {
            Object selectedItem = model.getSelectedItem();
            model.removeAllElements();
            for (String classSearchHistoryItem : classSearchHistoryItems) {
                model.addElement(classSearchHistoryItem);
            }
            if (selectedItem != null) {
                model.setSelectedItem(selectedItem);
            } else {
                model.setSelectedItem("");
            }
        }
    }
}
