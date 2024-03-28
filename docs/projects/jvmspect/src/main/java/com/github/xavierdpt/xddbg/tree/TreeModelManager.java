package com.github.xavierdpt.xddbg.tree;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

public class TreeModelManager {

    TreeModel mainModel;
    TreeModel filteredModel;

    public TreeModelManager(TreeModel mainModel) {
        this.mainModel = mainModel;
    }

    public TreeModel getMainModel() {
        return mainModel;
    }

    public void setFilteredModel(DefaultTreeModel filteredModel) {
        this.filteredModel = filteredModel;
    }

    public void useMainModel(JTree tree) {
        if (tree.getModel() != mainModel) {
            tree.setModel(mainModel);
        }
    }

    public void useFilteredModel(JTree classTree) {
        if (classTree.getModel() != filteredModel) {
            classTree.setModel(filteredModel);
        }
    }

    public TreeModel getFilteredModel() {
        return filteredModel;
    }
}
