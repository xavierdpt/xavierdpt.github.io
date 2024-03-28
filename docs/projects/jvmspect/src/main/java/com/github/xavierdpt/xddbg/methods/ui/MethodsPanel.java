package com.github.xavierdpt.xddbg.methods.ui;

import com.github.xavierdpt.xddbg.tree.BetterCellRenderer;
import com.github.xavierdpt.xddbg.tree.TreeModelManager;
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

public class MethodsPanel extends JPanel {
    private final JTree tree;
    private final XDDBG app;
    private final MethodsSearchPanel searchBox;
    private TreeModelManager treeModelManager = new TreeModelManager(
            new DefaultTreeModel(
                    new BetterTreeNode("All methods")
            )
    );

    public MethodsPanel(XDDBG app) {
        super(new BorderLayout());
        this.app = app;
        setBorder(BorderFactory.createTitledBorder("Methods"));
        searchBox = new MethodsSearchPanel(app);
        tree = new JTree(treeModelManager.getMainModel());
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
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_CONTEXT_MENU -> {
                        TreeUI ui = tree.getUI();
                        if (ui != null) {
                            TreePath anchorSelectionPath = tree.getAnchorSelectionPath();
                            if (anchorSelectionPath != null) {
                                Rectangle pathBounds = ui.getPathBounds(tree, anchorSelectionPath);
                                createPopup(e.getComponent(), pathBounds.x + pathBounds.width, pathBounds.y + pathBounds.height);
                            }
                        }
                    }
                    case KeyEvent.VK_ENTER -> app.showBytecode();
                }
            }
        });
        tree.setCellRenderer(new BetterCellRenderer(tree.getCellRenderer()));
        add(searchBox, BorderLayout.NORTH);
        add(SwingHelper.inScrollPane(tree), BorderLayout.CENTER);
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

                        JMenuItem setBreakpoint = new JMenuItem("Set breakpoint");
                        setBreakpoint.addActionListener(e1 -> app.setBreakpoint());
                        popupMenu.add(setBreakpoint);
                        popupMenu.show(component, x, y);
                    }
                }
            }
        }
    }

    public JTree getTree() {
        return tree;
    }

    public TreeModelManager getTreeModelManager() {
        return treeModelManager;
    }

    public boolean hideEmptyMethods() {
        return searchBox.config.getHideEmpty();
    }

    public void setHideEmptyMethods(boolean hideEmptyMethods) {
        searchBox.config.setHideEmpty(hideEmptyMethods);
    }

    public void filterMethods() {
        searchBox.filterMethods(app);
    }
}
