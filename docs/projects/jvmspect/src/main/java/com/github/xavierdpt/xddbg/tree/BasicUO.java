package com.github.xavierdpt.xddbg.tree;

public class BasicUO {
    private boolean visible = true;
    protected String name;
    private boolean highlight;

    public BasicUO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isHighlight() {
        return highlight;
    }

    public void setHighlight(boolean highlight) {
        this.highlight = highlight;
    }

    @Override
    public String toString() {
        return name;
    }
}
