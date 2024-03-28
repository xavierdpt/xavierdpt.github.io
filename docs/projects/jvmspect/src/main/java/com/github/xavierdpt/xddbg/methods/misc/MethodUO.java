package com.github.xavierdpt.xddbg.methods.misc;

public class MethodUO {
    private boolean visible = true;
    protected String partName;

    public MethodUO(String partName) {
        this.partName = partName;
    }

    public String getPartName() {
        return partName;
    }

    public boolean isVisible() {
        return visible;
    }

    @Override
    public String toString() {
        return partName;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
