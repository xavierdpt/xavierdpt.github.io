package com.github.xavierdpt.xddbg.methods.misc;

import com.github.xavierdpt.xddbg.TreeHelper;
import com.github.xavierdpt.xddbg.tree.BasicUO;
import com.github.xavierdpt.xddbg.tree.BetterTreeNode;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class TreeMethods {
    public static void fillMethodTree(JTree tree, String referenceName, String methodName, String signature, boolean visible, boolean empty) {
        DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
        BetterTreeNode root = (BetterTreeNode) model.getRoot();
        DefaultMutableTreeNode classNode = TreeHelper.findNode(root, referenceName);
        if (classNode == null) {
            classNode = new BetterTreeNode(new BasicUO(referenceName));
            model.insertNodeInto(classNode, root, root.getChildCount());
        }
        DefaultMutableTreeNode methodNode = TreeHelper.findNode(classNode, methodName);
        if (methodNode == null) {
            methodNode = new BetterTreeNode(new BasicUO(methodName));
            model.insertNodeInto(methodNode, classNode, classNode.getChildCount());
        }
        DefaultMutableTreeNode signatureNode = TreeHelper.findNode(methodNode, signature);
        if (signatureNode == null) {
            signatureNode = new BetterTreeNode(new BasicUO(signature));
            model.insertNodeInto(signatureNode, methodNode, methodNode.getChildCount());
        }
        if (signatureNode.getUserObject() instanceof BasicUO basicUO) {
            basicUO.setHighlight(visible);
            basicUO.setSecondary(empty);
        }

    }
}
