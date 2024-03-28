package com.github.xavierdpt.xddbg.tree;

public class BasicUO implements Cloneable {
    protected String name;
    private boolean highlight;
    private boolean secondary;

    public BasicUO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isHighlight() {
        return highlight;
    }

    public void setHighlight(boolean highlight) {
        this.highlight = highlight;
    }

    public boolean isSecondary() {
        return secondary;
    }

    public void setSecondary(boolean secondary) {
        this.secondary = secondary;
    }

    @Override
    public String toString() {
        return name;
    }
    @Override
    public BasicUO clone() {
        try {
            return (BasicUO) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
