package com.github.xavierdpt.xddbg.classes;

import com.github.xavierdpt.xddbg.tree.BasicUO;

public class ClassUO extends BasicUO {
    private final String fullName;

    public ClassUO(String simpleName, String fullName) {
        super(simpleName);
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}
