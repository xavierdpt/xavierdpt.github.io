package com.github.xavierdpt.xddbg;

import com.github.xavierdpt.xddbg.tree.BasicUO;
import com.github.xavierdpt.xddbg.tree.BetterTreeNode;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
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

    @Deprecated
    public static void clearTree(JTree tree) {
        clearTree(tree.getModel());
    }

    public static void clearTree(TreeModel model) {
        Object root = model.getRoot();
        if (root instanceof DefaultMutableTreeNode defaultMutableTreeNode) {
            defaultMutableTreeNode.removeAllChildren();
        }
    }

    public static void expandAll(JTree tree) {
        var foundFirstLeaf = false;
        if (tree.getModel() instanceof DefaultTreeModel model) {
            if (model.getRoot() instanceof DefaultMutableTreeNode rootDMTN) {
                var e = rootDMTN.depthFirstEnumeration();
                while (e.hasMoreElements()) {
                    var node = e.nextElement();
                    if (node instanceof BetterTreeNode nodeBTN) {
                        var path = new TreePath(nodeBTN.getPath());
                        tree.expandPath(path);
                        if (node.isLeaf() && !foundFirstLeaf) {
                            foundFirstLeaf = true;
                            tree.setSelectionPath(path);
                            tree.scrollRectToVisible(tree.getPathBounds(path));
                            tree.requestFocus();
                        }

                    }
                }
            }
        }
    }

    public static void expandFirst(JTree tree) {
        if (tree.getModel() instanceof DefaultTreeModel model) {
            if (model.getRoot() instanceof DefaultMutableTreeNode rootDMTN) {
                var path = new TreePath(rootDMTN.getPath());
                tree.expandPath(path);
                tree.setSelectionPath(path);
                tree.requestFocus();
            }
        }

    }
}
