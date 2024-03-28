package com.github.xavierdpt.xddbg.classes.ui;

import java.awt.Point;

public class BetterPoint {
    private final Point ref;

    public BetterPoint(Point ref) {
        this.ref = ref;
    }

    public BetterPoint translate(Point point) {
        ref.translate(point.x, point.y);
        return this;
    }

    public BetterPoint translate(int x, int y) {
        ref.translate(x,y);
        return this;
    }

    public Point back() {
        return ref;
    }

    public int getX() {
        return ref.x;
    }

    public int getY() {
        return ref.y;
    }
}
