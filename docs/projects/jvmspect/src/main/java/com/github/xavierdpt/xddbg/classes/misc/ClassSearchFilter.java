package com.github.xavierdpt.xddbg.classes.misc;

import com.github.xavierdpt.xddbg.utils.CloneHelper;
import com.github.xavierdpt.xddbg.tree.TreeModelManager;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import java.util.Enumeration;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class ClassSearchFilter {

    private int numberOfVisibleClasses = 0;

    public void filter(String searchText, TreeModelManager treeModelManager, JTree classTree) {
        numberOfVisibleClasses = 0;
        Pattern pattern = Pattern.compile(modifySearchText(searchText));
        TreeModel mainModel = treeModelManager.getMainModel();
        Object root = mainModel.getRoot();
        if (root instanceof DefaultMutableTreeNode rootNode) {
            DefaultMutableTreeNode rootClone = CloneHelper.clone(rootNode);
            DefaultTreeModel filteredModel = new DefaultTreeModel(rootClone);
            filter(rootNode, rootClone, pattern.asMatchPredicate());
            treeModelManager.setFilteredModel(filteredModel);
            treeModelManager.useFilteredModel(classTree);
        }
    }




    public int getNumberOfVisibleClasses() {
        return numberOfVisibleClasses;
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

        private boolean filter(DefaultMutableTreeNode node, DefaultMutableTreeNode nodeClone, Predicate<String> matchPredicate) {
        boolean visible = false;
        Object userObject = node.getUserObject();
        if (userObject instanceof ClassUO leafNode) {
            visible = matchPredicate.test(leafNode.getFullName());
            if (visible) {
                ++numberOfVisibleClasses;
            }
        }
        Enumeration<? extends TreeNode> children = node.children();
        while (children.hasMoreElements()) {
            TreeNode child = children.nextElement();
            if (child instanceof DefaultMutableTreeNode childDMTN) {
                DefaultMutableTreeNode childClone = CloneHelper.clone(childDMTN);
                boolean childVisible = filter(childDMTN, childClone, matchPredicate);
                if (childVisible) {
                    nodeClone.add(childClone);
                }
                visible |= childVisible;
            }
        }
        return visible;
    }


}
