package com.github.xavierdpt.xddbg.tree;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.function.Function;

public class BetterTreeNode extends DefaultMutableTreeNode {

    public BetterTreeNode(Object userObject) {
        super(userObject);
    }

    private boolean isVisible() {
        if (userObject instanceof BasicUO classUO) {
            return classUO.isVisible();
        }
        return true;
    }

    @Override
    public TreeNode getChildAt(int index) {
        if (children == null) {
            throw new ArrayIndexOutOfBoundsException("node has no children");
        }
        int realIndex = -1;
        int visibleIndex = -1;
        Enumeration<TreeNode> e = children.elements();
        while (e.hasMoreElements()) {
            TreeNode node = e.nextElement();
            if (node instanceof BetterTreeNode betterNode && betterNode.isVisible()) {
                ++visibleIndex;
            }
            ++realIndex;
            if (visibleIndex == index) {
                return children.elementAt(realIndex);
            }
        }
        throw new ArrayIndexOutOfBoundsException("index unmatched");
    }

    @Override
    public int getChildCount() {
        if (children == null) {
            return 0;
        }
        int count = 0;
        Enumeration<TreeNode> e = children.elements();
        while (e.hasMoreElements()) {
            TreeNode node = e.nextElement();
            if (node instanceof BetterTreeNode betterNode) {
                if (betterNode.isVisible()) {
                    ++count;
                }
            } else {
                ++count;
            }
        }
        return count;
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
}
