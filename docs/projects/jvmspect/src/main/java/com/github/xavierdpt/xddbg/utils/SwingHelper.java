package com.github.xavierdpt.xddbg.utils;

import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class SwingHelper {
    public static JScrollPane inScrollPane(java.awt.Component component) {
        JScrollPane scrollPane = new JScrollPane(component);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        return scrollPane;
    }

    public static JSplitPane split(int orientation, java.awt.Component placeholderTree, java.awt.Component classPanelLayout) {
        JSplitPane splitPane = new JSplitPane(orientation, placeholderTree, classPanelLayout);
        splitPane.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                splitPane.setDividerLocation(.5D);
                //splitPane.removeComponentListener(this);
            }
        });
        return splitPane;
    }

    public static Point getLocationRelativeTo(java.awt.Component component, java.awt.Component ancestor) {
        Point result = new Point(0, 0);
        java.awt.Component c = component;

        do {
            Point l = c.getLocation();
            result.translate(l.x, l.y);
            c = c.getParent();
        } while (c != ancestor && c != null);
        return result;
    }


    public static Color withAlpha(Color color, float alpha) {
        return new Color(
                color.getRed(),
                color.getGreen(),
                color.getBlue(),
                new Color(0f, 0f, 0f, alpha).getTransparency()
        );
    }
}
