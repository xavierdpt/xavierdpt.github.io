package com.github.xavierdpt.xddbg.methods.ui;

import com.github.xavierdpt.xddbg.TreeHelper;
import com.github.xavierdpt.xddbg.XDDBG;
import com.github.xavierdpt.xddbg.methods.misc.MethodSearchFilter;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTree;
import java.awt.Color;
import java.awt.FlowLayout;

public class MethodsSearchPanel extends JPanel {

    private final JCheckBox hideEmpty;

    public final Config config = new Config();

    public MethodsSearchPanel(XDDBG app) {
        super(new FlowLayout(FlowLayout.LEADING));
        hideEmpty = new JCheckBox("Hide empty methods");
        hideEmpty.addActionListener(e -> {
            MethodSearchFilter methodSearchFilter = new MethodSearchFilter();
            methodSearchFilter.filter(hideEmpty.isSelected(), app.getMethodTreeModelManager(), app.getMethodTree());
            JTree methodTree = app.getMethodTree();
            if (methodSearchFilter.getNumberOfVisibleMethods() <= 10) {
                TreeHelper.expandAll(methodTree);
            } else {
                TreeHelper.expandFirst(methodTree);
            }
        });
        add(hideEmpty);
        DefaultComboBoxModel<Object> objectDefaultComboBoxModel = new DefaultComboBoxModel<>();
        objectDefaultComboBoxModel.addElement("");
    }

    public void filterMethods(XDDBG app) {
        MethodSearchFilter methodSearchFilter = new MethodSearchFilter();
        methodSearchFilter.filter(hideEmpty.isSelected(), app.getMethodTreeModelManager(), app.getMethodTree());
        JTree methodTree = app.getMethodTree();
        if (methodSearchFilter.getNumberOfVisibleMethods() <= 10) {
            TreeHelper.expandAll(methodTree);
        } else {
            TreeHelper.expandFirst(methodTree);
        }
    }

    class Config {
        public void setHideEmpty(boolean selected) {
            hideEmpty.setSelected(selected);
        }

        public boolean getHideEmpty() {
            return hideEmpty.isSelected();
        }
    }
}
