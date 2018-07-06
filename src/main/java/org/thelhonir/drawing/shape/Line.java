package org.thelhonir.drawing.shape;

import java.util.ArrayList;
import java.util.List;

import org.thelhonir.drawing.shape.builder.PointBuilder;

public class Line {
    private List<Point> line = new ArrayList<Point>();
    private Orientation lineOrientation;

    public Line(Point from, Point to) throws Exception {
        setLineOrientation(from, to);
        buildLine(from, to);
    }

    public List<Point> getLine() {
        return this.line;
    }

    public Orientation getLiOrientation() {
        return this.lineOrientation;
    }

    private void buildLine(Point from, Point to) throws Exception {
        // TODO create a point comparator and based on that build the line to right or
        // left
        // Adding force brute logic TODO refactor this!

        // FIRST CASE
        switch (this.lineOrientation) {
        case HORIZONTAL_RIGHT:
            for (int i = from.getY(); i < to.getY(); i++) {
                this.line.add(new PointBuilder().coordinateX(from.getX()).coordinateY(i).build());
            }
            break;
        case HORIZONTAL_LEFT:
            for (int i = to.getY(); i < from.getY(); i++) {
                this.line.add(new PointBuilder().coordinateX(to.getX()).coordinateY(i).build());
            }
            break;
        case VERTICAL_DOWN:
            for (int i = from.getX(); i < to.getX(); i++) {
                this.line.add(new PointBuilder().coordinateX(i).coordinateY(from.getY()).build());
            }
            break;
        case VERTICAL_UP:
            for (int i = to.getX(); i < from.getX(); i++) {
                this.line.add(new PointBuilder().coordinateX(i).coordinateY(to.getY()).build());
            }
            break;
        default:
            throw new Exception("NOT A LINE!");
        }
    }

    private void setLineOrientation(Point from, Point to) {
        // REFACTOR THIS!!
        if (from.getX() == to.getX()) {
            if (from.getY() < to.getY()) {
                this.lineOrientation = Orientation.HORIZONTAL_RIGHT;
            } else {
                this.lineOrientation = Orientation.HORIZONTAL_LEFT;
            }
        } else {
            if (from.getX() < to.getX()) {
                this.lineOrientation = Orientation.VERTICAL_DOWN;
            } else {
                this.lineOrientation = Orientation.VERTICAL_UP;
            }
        }

    }

}
