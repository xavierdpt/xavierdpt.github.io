package com.github.xavierdpt.xddbg.utils;

import javax.swing.tree.DefaultMutableTreeNode;

public class CloneHelper {
    public static DefaultMutableTreeNode clone(DefaultMutableTreeNode node) {
        return (DefaultMutableTreeNode) node.clone();
    }

}
