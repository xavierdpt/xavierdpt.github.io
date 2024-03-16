package com.github.xavierdpt.jvmspect.charts.library;

import java.util.HashMap;
import java.util.Map;

public class StringTree {

    Map<String, StringTree> children = new HashMap<>();
    public StringTree get(String name) {
        return children.computeIfAbsent(name, s -> new StringTree());
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }
}
