package com.github.xavierdpt.xddbg.classes.ui.notready;

import com.github.xavierdpt.xddbg.classes.ui.BetterPoint;
import com.github.xavierdpt.xddbg.utils.SwingHelper;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import static java.util.Collections.emptyList;

public abstract class BetterComboBox<T, MainComponent extends java.awt.Component, ItemListComponent extends java.awt.Component> extends JPanel {

    protected final MainComponent mainComponent;
    protected final ItemListComponent itemListComponent;

    private final JFrame owner;
    private CustomPopup popup;
    private Supplier<List<java.awt.Component>> targetComponents;
    private final List<Runnable> popupShownListeners = new ArrayList<>();

    public BetterComboBox(MainComponent mainComponent, ItemListComponent itemListComponent, JFrame owner) {
        super(new BorderLayout());
        this.mainComponent = mainComponent;
        this.itemListComponent = itemListComponent;
        this.owner = owner;
        add(mainComponent, BorderLayout.CENTER);
        JButton arrowButton = new JButton("V");
        arrowButton.setBorder(BorderFactory.createEmptyBorder(0,8,0,8));
        arrowButton.addActionListener(e -> togglePopup());
        add(arrowButton, BorderLayout.EAST);
    }

    protected java.awt.Component wrapItemListComponent(Dimension minimumSize, Dimension maximumSize) {
        return itemListComponent;
    }

    public void togglePopup() {
        if (popup != null && popup.isVisible()) {
            hidePopup();
        } else {
            showPopup();
        }
    }

    public abstract void setCurrentItem(T item);

    public abstract T getCurrentItem();

    public abstract void addItem(T item);

    public abstract void removeItem(T item);


    public abstract T getItemAt(int index);

    public abstract int getItemCount();


    public abstract void clearItems();

    public abstract void insertAt(int index, String item);

    public void showPopup() {
        BetterPoint popupLocation = new BetterPoint(owner.getLocationOnScreen())
                .translate(SwingHelper.getLocationRelativeTo(mainComponent, owner))
                .translate(0, mainComponent.getHeight());
        Insets ownerInsets = owner.getInsets();
        int maxWidth = owner.getWidth() - popupLocation.getX() - ownerInsets.left - ownerInsets.right;
        int maxHeight = owner.getHeight() - popupLocation.getY() - ownerInsets.top - ownerInsets.bottom;
        Dimension maximumSize = new Dimension(
                maxWidth > 100 ? maxWidth - 10 : maxWidth,
                maxHeight > 100 ? maxHeight - 10 : maxHeight);
        Dimension minimumSize = new Dimension(mainComponent.getWidth(), mainComponent.getHeight());
        if (popup == null) {
            popup = new CustomPopup(owner, wrapItemListComponent(minimumSize, maximumSize), minimumSize, maximumSize);
        }
        Optional.of(targetComponents)
                .map(Supplier::get)
                .orElse(emptyList())
                .forEach(component -> popup.registerEscape(component));
        popup.setLocation(popupLocation.back());
        popup.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                popup = null;
            }
        });

        popup.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                popupShownListeners.forEach(Runnable::run);
                popup.pack();
            }
        });

        popup.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
            }
        });

        popup.setVisible(true);
    }

    public void hidePopup() {
        popup.setVisible(false);
    }

    protected void registerEscape(Supplier<List<java.awt.Component>> targetComponents) {
        this.targetComponents = targetComponents;
    }

    protected void addPopupShownListener(Runnable runnable) {
        popupShownListeners.add(runnable);
    }
}
