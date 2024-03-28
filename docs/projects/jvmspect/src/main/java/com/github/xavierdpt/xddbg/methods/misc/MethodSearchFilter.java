package com.github.xavierdpt.xddbg.methods.misc;

import com.github.xavierdpt.xddbg.utils.CloneHelper;
import com.github.xavierdpt.xddbg.tree.TreeModelManager;
import com.github.xavierdpt.xddbg.tree.BasicUO;
import com.github.xavierdpt.xddbg.utils.EI;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import java.util.Enumeration;

public class MethodSearchFilter {

    private int numberOfVisibleMethods = 0;

    public void filter(boolean hideEmpty, TreeModelManager treeModelManager, JTree methodTree) {
        numberOfVisibleMethods = 0;
        TreeModel mainModel = treeModelManager.getMainModel();
        if (hideEmpty) {
            TreeModel currentFilteredModel = treeModelManager.getFilteredModel();
            if (currentFilteredModel != null) {
                updateMethodCountFromModel(currentFilteredModel);
                treeModelManager.useFilteredModel(methodTree);
            } else {
                if (mainModel.getRoot() instanceof DefaultMutableTreeNode rootNode) {
                    DefaultMutableTreeNode rootClone = CloneHelper.clone(rootNode);
                    DefaultTreeModel newFilteredModel = new DefaultTreeModel(rootClone);
                    filter(rootNode, rootClone, hideEmpty);
                    treeModelManager.setFilteredModel(newFilteredModel);
                    treeModelManager.useFilteredModel(methodTree);
                }
            }
        } else {
            updateMethodCountFromModel(mainModel);
            treeModelManager.useMainModel(methodTree);
        }
    }

    private void updateMethodCountFromModel(TreeModel mainModel) {
        if (mainModel.getRoot() instanceof DefaultMutableTreeNode rootDMTN) {
            for (TreeNode node : new EI<>(rootDMTN.depthFirstEnumeration())) {
                if (node.isLeaf()) {
                    ++numberOfVisibleMethods;
                }
            }
        }
    }

    public int getNumberOfVisibleMethods() {
        return numberOfVisibleMethods;
    }

    private boolean filter(DefaultMutableTreeNode node, DefaultMutableTreeNode nodeClone, boolean hideEmpty) {
        boolean visible = false;
        if (node instanceof DefaultMutableTreeNode defaultMutableTreeNode) {
            if (node.isLeaf()) {
                Object userObject = defaultMutableTreeNode.getUserObject();
                if (userObject instanceof BasicUO leafNode) {
                    visible = !(hideEmpty && leafNode.isSecondary());
                    if (visible) {
                        ++numberOfVisibleMethods;
                    }
                }
            }

        }
        Enumeration<? extends TreeNode> children = node.children();
        while (children.hasMoreElements()) {
            TreeNode child = children.nextElement();
            if (child instanceof DefaultMutableTreeNode childDMTN) {
                DefaultMutableTreeNode childClone = CloneHelper.clone(childDMTN);
                boolean childVisible = filter(childDMTN, childClone, hideEmpty);
                if (childVisible) {
                    nodeClone.add(childClone);
                }
                visible |= childVisible;
            }
        }
        return visible;

    }
}
