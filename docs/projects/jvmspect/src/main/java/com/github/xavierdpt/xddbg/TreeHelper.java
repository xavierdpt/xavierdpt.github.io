package com.github.xavierdpt.xddbg;

import com.github.xavierdpt.xddbg.tree.BasicUO;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import java.util.Enumeration;

public class TreeHelper {
    public static DefaultMutableTreeNode findNode(DefaultMutableTreeNode root, String name) {
        Enumeration<TreeNode> children = root.children();
        while (children.hasMoreElements()) {
            TreeNode node = children.nextElement();
            if (node instanceof DefaultMutableTreeNode defaultMutableTreeNode) {
                Object userObject = defaultMutableTreeNode.getUserObject();
                if (userObject instanceof BasicUO basicUO) {
                    if (name.equals(basicUO.getName())) {
                        return defaultMutableTreeNode;
                    }
                }
            }
        }
        return null;
    }

    public static void clearTree(JTree tree) {
        TreeModel model = tree.getModel();
        if (model instanceof DefaultTreeModel defaultTreeModel) {
            Object root = model.getRoot();
            if (root instanceof DefaultMutableTreeNode defaultMutableTreeNode) {
                defaultMutableTreeNode.removeAllChildren();
                defaultTreeModel.reload();
            }
        }

    }
}
