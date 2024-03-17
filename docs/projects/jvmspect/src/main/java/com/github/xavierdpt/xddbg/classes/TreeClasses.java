package com.github.xavierdpt.xddbg.classes;

import com.github.xavierdpt.xddbg.tree.BasicUO;
import com.github.xavierdpt.xddbg.tree.BetterTreeNode;
import com.sun.jdi.ReferenceType;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import java.util.Enumeration;
import java.util.List;

public class TreeClasses {
    public static void fillTree(JTree rightTree, String name) {
        // TODO: Move to classes.*
        DefaultTreeModel model = (DefaultTreeModel) rightTree.getModel();
        BetterTreeNode root = (BetterTreeNode) model.getRoot();
        String[] parts = name.split("\\.");
        partLoop:
        for (int i = 0; i < parts.length; i++) {
            String partName = parts[i];
            Enumeration<TreeNode> children = root.children();
            while (children.hasMoreElements()) {
                BetterTreeNode treeNode = (BetterTreeNode) children.nextElement();
                Object userObject = treeNode.getUserObject();
                if (partName.equals(String.valueOf(userObject))) {
                    root = treeNode;
                    continue partLoop;
                }
            }
            BetterTreeNode newRoot;
            if (i == parts.length - 1) {
                newRoot = new BetterTreeNode(new ClassUO(partName, name));
            } else {
                newRoot = new BetterTreeNode(new BasicUO(partName));
            }
            model.insertNodeInto(newRoot, root, root.getChildCount());
            root = newRoot;
        }


    }

    public static void fillTree(JTree tree, List<ReferenceType> referenceTypes) {
        // TODO: Move to classes.*
        for (ReferenceType referenceType : referenceTypes) {
            String name = referenceType.name();
            fillTree(tree, name);
        }
    }
}
