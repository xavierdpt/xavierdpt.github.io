package com.github.xavierdpt.xddbg.classes.ui;

import com.github.xavierdpt.xddbg.XDDBG;
import com.github.xavierdpt.xddbg.classes.misc.ClassUO;
import com.github.xavierdpt.xddbg.tree.TreeModelManager;
import com.github.xavierdpt.xddbg.tree.BetterTreeNode;
import com.github.xavierdpt.xddbg.utils.SwingHelper;

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
import java.util.List;

public class ClassPanel extends JPanel {
    private final JTree tree;
    private final XDDBG app;
    private final ClassSearchPanel searchBox;
    private final TreeModelManager treeModelManager = new TreeModelManager(
            new DefaultTreeModel(
                    new BetterTreeNode("All classes")
            )
    );

    public ClassPanel(XDDBG app) {
        super(new BorderLayout());
        this.app = app;
        setBorder(BorderFactory.createTitledBorder("Classes"));
        searchBox = new ClassSearchPanel(app);
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
                    case KeyEvent.VK_ENTER -> app.findMethods();
                }
            }
        });
        add(searchBox, BorderLayout.NORTH);
        add(SwingHelper.inScrollPane(tree), BorderLayout.CENTER);
    }

    private void createPopup(Component component, int x, int y) {
        Object lastSelectedPathComponent = tree.getLastSelectedPathComponent();
        if (lastSelectedPathComponent != null) {
            if (lastSelectedPathComponent instanceof BetterTreeNode betterNode) {
                Object userObject = betterNode.getUserObject();
                if (userObject instanceof ClassUO) {
                    JPopupMenu popupMenu = new JPopupMenu();
                    JMenuItem findMethods = new JMenuItem("Find Methods");
                    findMethods.addActionListener(e1 -> app.findMethods());
                    popupMenu.add(findMethods);
                    popupMenu.show(component, x, y);
                }
            }
        }
    }

    public JTree getTree() {
        return tree;
    }

    public void setClassSearch(String input) {
        searchBox.setSearchInputText(input);
    }

    public String getClassSearchText() {
        return searchBox.getSearchInputText();

    }

    public TreeModelManager getTreeModelManager() {
        return treeModelManager;
    }

    public List<String> getClassSearchHistory() {
        return searchBox.getClassSearchHistory();
    }

    public void setClassSearchHistory(List<String> classSearchHistoryItems) {
        searchBox.setClassSearchHistory(classSearchHistoryItems);
    }
}
