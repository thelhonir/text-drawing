package org.thelhonir.drawing.shape.builder;

import org.thelhonir.drawing.shape.Point;

public class PointBuilder {
    private int x = 0;
    private int y = 0;
    private boolean visible = false;

    public PointBuilder coordinateX(int x){
        this.x = x;
        return this;
    }

    public PointBuilder coordinateY(int y){
        this.y = y;
        return this;
    }

    public PointBuilder setVisibility(boolean visible){
        this.visible = visible;
        return this;
    }

    public Point build(){
        return new Point(this.x, this.y, this.visible);
    }
}
