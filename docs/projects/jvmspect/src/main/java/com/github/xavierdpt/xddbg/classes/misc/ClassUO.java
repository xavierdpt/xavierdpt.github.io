package com.github.xavierdpt.xddbg.classes.misc;

import com.github.xavierdpt.xddbg.tree.BasicUO;

public class ClassUO extends BasicUO implements Cloneable {
    private final String fullName;

    public ClassUO(String simpleName, String fullName) {
        super(simpleName);
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public ClassUO clone() {
        return (ClassUO) super.clone();
    }

}
