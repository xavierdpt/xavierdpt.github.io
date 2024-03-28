package com.github.xavierdpt.xddbg.tree;

import com.github.xavierdpt.xddbg.tree.BasicUO;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import java.awt.Color;
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
        boolean gray = false;
        if (value instanceof DefaultMutableTreeNode defaultMutableTreeNode) {
            Object userObject = defaultMutableTreeNode.getUserObject();
            if (userObject instanceof BasicUO basicUO) {
                if (basicUO.isHighlight()) {
                    highlight = true;
                }
                if (basicUO.isSecondary()) {
                    gray = true;
                }
            }

        }
        if (highlight) {
            component.setFont(component.getFont().deriveFont(Font.BOLD));
        } else {
            component.setFont(component.getFont().deriveFont(Font.PLAIN));
        }
        if (gray) {
            component.setForeground(Color.LIGHT_GRAY);
        } else {
            component.setForeground(Color.BLACK);
        }
        return component;
    }
}
