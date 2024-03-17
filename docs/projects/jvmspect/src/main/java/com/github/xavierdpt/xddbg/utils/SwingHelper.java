package com.github.xavierdpt.xddbg.utils;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Component;

public class SwingHelper {
    public static JScrollPane createScrollPane(Component component) {
        JScrollPane scrollPane = new JScrollPane(component);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        return scrollPane;
    }
}
