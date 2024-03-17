package com.github.xavierdpt.xddbg.methods;

import com.github.xavierdpt.xddbg.tree.BasicUO;
import com.github.xavierdpt.xddbg.tree.BetterTreeNode;
import com.github.xavierdpt.xddbg.utils.SwingHelper;
import com.github.xavierdpt.xddbg.XDDBG;

import javax.swing.BorderFactory;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.plaf.TreeUI;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class XMethods extends JPanel {
    private final JTree tree;
    private final XDDBG app;

    public XMethods(XDDBG app) {
        super(new BorderLayout());
        this.app = app;
        setBorder(BorderFactory.createTitledBorder("Methods"));
        XMethodSearchBox searchBox = new XMethodSearchBox(app);
        tree = new JTree(new DefaultTreeModel(new BetterTreeNode("All methods")));
        tree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    int row = tree.getClosestRowForLocation(e.getX(), e.getY());
                    if (row != -1) {
                        tree.setSelectionRow(row);
                        createPopup(e.getComponent(), e.getX(), e.getY());
                    }

                }
            }
        });
        tree.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_CONTEXT_MENU) {
                    TreeUI ui = tree.getUI();
                    if (ui != null) {
                        TreePath anchorSelectionPath = tree.getAnchorSelectionPath();
                        if (anchorSelectionPath != null) {
                            Rectangle pathBounds = ui.getPathBounds(tree, anchorSelectionPath);
                            createPopup(e.getComponent(), pathBounds.x + pathBounds.width, pathBounds.y + pathBounds.height);
                        }
                    }

                }
            }
        });
        tree.setCellRenderer(new BetterCellRenderer(tree.getCellRenderer()));
        add(searchBox, BorderLayout.NORTH);
        add(SwingHelper.createScrollPane(tree), BorderLayout.CENTER);
    }

    private void createPopup(Component component, int x, int y) {
        Object lastSelectedPathComponent = tree.getLastSelectedPathComponent();
        if (lastSelectedPathComponent != null) {
            if (lastSelectedPathComponent instanceof BetterTreeNode betterNode) {
                if (betterNode.getChildCount() == 0) {
                    Object userObject = betterNode.getUserObject();
                    if (userObject instanceof BasicUO) {
                        JPopupMenu popupMenu = new JPopupMenu();
                        JMenuItem seeBytecode = new JMenuItem("See bytecode");
                        seeBytecode.addActionListener(e1 -> app.showBytecode());
                        popupMenu.add(seeBytecode);
                        popupMenu.show(component, x, y);
                    }
                }
            }
        }
    }

    public JTree getTree() {
        return tree;
    }
}
