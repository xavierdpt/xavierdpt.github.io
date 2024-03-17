package com.github.xavierdpt.xddbg.methods;

import com.github.xavierdpt.xddbg.tree.BasicUO;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import java.awt.Component;
import java.awt.Font;

public class BetterCellRenderer implements TreeCellRenderer {
    private final TreeCellRenderer defaultCellRenderer;

    public BetterCellRenderer(TreeCellRenderer defaultCellRenderer) {
        this.defaultCellRenderer = defaultCellRenderer;
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        Component component = defaultCellRenderer.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
        boolean highlight = false;
        if (value instanceof DefaultMutableTreeNode defaultMutableTreeNode) {
            Object userObject = defaultMutableTreeNode.getUserObject();
            if (userObject instanceof BasicUO basicUO && basicUO.isHighlight()) {
                highlight = true;
            }
        }
        if (highlight) {
            component.setFont(component.getFont().deriveFont(Font.BOLD));
        } else {
            component.setFont(component.getFont().deriveFont(Font.PLAIN));
        }
        return component;
    }
}
