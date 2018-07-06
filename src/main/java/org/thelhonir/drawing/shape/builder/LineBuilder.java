package org.thelhonir.drawing.shape.builder;

import org.thelhonir.drawing.shape.Line;
import org.thelhonir.drawing.shape.Point;

public class LineBuilder {
    private Point from;
    private Point to;

    public LineBuilder from(Point from){
        this.from = from;
        return this;
    }

    public LineBuilder to(Point to){
        this.to = to;
        return this;
    }

    public Line build() throws Exception{
        return new Line(this.from, this.to);
    }

}
