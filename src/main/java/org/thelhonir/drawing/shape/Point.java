package org.thelhonir.drawing.shape;

public class Point {
    private final int x;
    private final int y;
    private boolean visible;

    public Point(int x, int y, boolean visible) {
        this.x = x;
        this.y = y;
        this.visible = visible;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setVisibility(boolean visible){
        this.visible = visible;
    }

}
