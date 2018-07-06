package org.thelhonir.drawing.canvas;

import org.thelhonir.drawing.shape.Point;
import org.thelhonir.drawing.shape.builder.PointBuilder;

public class Canvas {

    private Point[][] drawingArea;

    public Canvas(int width, int height) {
        setDrawingArea(width, height);
    }

    public Point[][] getDrawingArea() {
        return this.drawingArea;
    }

    private void setDrawingArea(int width, int height) {
        this.drawingArea = new Point[width][height];
        for (int i = 0; i < this.drawingArea.length; i++) {
            for (int j = 0; j < this.drawingArea[i].length; j++) {
                this.drawingArea[i][j] = new PointBuilder().coordinateX(i).coordinateY(i).build();
            }
        }
    }

    

}
