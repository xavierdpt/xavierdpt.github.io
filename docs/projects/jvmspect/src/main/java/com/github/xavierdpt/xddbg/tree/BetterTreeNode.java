package com.github.xavierdpt.xddbg.tree;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.Comparator;
import java.util.function.Function;

public class BetterTreeNode extends DefaultMutableTreeNode implements Cloneable {

    public BetterTreeNode(Object userObject) {
        super(userObject);
    }


    @Override
    public void add(MutableTreeNode newChild) {
        super.add(newChild);
        sortChildren();
    }

    @Override
    public void insert(MutableTreeNode newChild, int childIndex) {
        super.insert(newChild, childIndex);
        sortChildren();
    }

    private void sortChildren() {
        Function<? super TreeNode, String> keyExtractor = (Function<TreeNode, String>) treeNode -> {
            if (treeNode instanceof DefaultMutableTreeNode defaultMutableTreeNode) {
                Object userObject = defaultMutableTreeNode.getUserObject();
                if (userObject instanceof BasicUO basicUO) {
                    return basicUO.getName();
                }
            }
            return "";
        };
        this.children.sort(Comparator.comparing(keyExtractor).thenComparing(System::identityHashCode));
    }

    @Override
    public BetterTreeNode clone() {
        return (BetterTreeNode) super.clone();
    }

}
