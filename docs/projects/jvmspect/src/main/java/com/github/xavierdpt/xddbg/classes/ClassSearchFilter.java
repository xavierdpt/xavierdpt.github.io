package com.github.xavierdpt.xddbg.classes;

import com.github.xavierdpt.xddbg.tree.BasicUO;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import java.util.Enumeration;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class ClassSearchFilter {
    public static void filter(DefaultTreeModel defaultTreeModel, String searchText) {
        Pattern pattern = Pattern.compile(modifySearchText(searchText));
        Object root = defaultTreeModel.getRoot();
        if (root instanceof TreeNode treeNode) {
            filter(treeNode, pattern.asMatchPredicate());
        }
        defaultTreeModel.reload();
    }

    private static String modifySearchText(String searchText) {
        searchText = searchText.replaceAll("\\.", "\\\\.");
        searchText = searchText.replaceAll(":", ".");
        if (!searchText.startsWith("^")) {
            searchText = ".*" + searchText;
        }
        if (!searchText.endsWith("$")) {
            searchText = searchText + ".*";
        }
        return searchText;
    }

    private static boolean filter(TreeNode node, Predicate<String> matchPredicate) {
        boolean visible = false;
        if (node instanceof DefaultMutableTreeNode defaultMutableTreeNode) {
            Object userObject = defaultMutableTreeNode.getUserObject();
            if (userObject instanceof ClassUO leafNode) {
                visible = matchPredicate.test(leafNode.getFullName());
            }
        }
        Enumeration<? extends TreeNode> children = node.children();
        while (children.hasMoreElements()) {
            visible |= filter(children.nextElement(), matchPredicate);
        }
        setVisible(node, visible);
        return visible;

    }

    private static void setVisible(TreeNode node, boolean visible) {
        if (node instanceof DefaultMutableTreeNode defaultMutableTreeNode) {
            Object userObject = defaultMutableTreeNode.getUserObject();
            if (userObject instanceof BasicUO classUO) {
                classUO.setVisible(visible);
            }
        }
    }
}
