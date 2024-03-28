package com.github.xavierdpt.xddbg.tree;

import com.github.xavierdpt.xddbg.tree.BasicUO;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

public class TreeNodeHelper {
    public static boolean isSecondary(TreeNode node) {
        if (node instanceof DefaultMutableTreeNode nodeDMTN) {
            Object userObject = nodeDMTN.getUserObject();
            if (userObject instanceof BasicUO basicUO) {
                return basicUO.isSecondary();
            }
        }
        return false;
    }
}
