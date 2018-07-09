package org.thelhonir.drawing.canvas;

import java.util.HashMap;

import org.thelhonir.drawing.point.Coordinates;
import org.thelhonir.drawing.point.Point;
import org.thelhonir.drawing.point.builder.PointBuilder;

public class Canvas {

    private HashMap<Coordinates, Point> matrix = new HashMap<Coordinates, Point>();
    private int width;
    private int height;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        setDrawingArea(width, height);
    }

    public HashMap<Coordinates, Point> getMatrix() {
        return this.matrix;
    }

    /**
     * Sets the Coordinates and Points inside of the boundaries of the matrix.
     */
    private void setDrawingArea(int width, int height) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                matrix.put(new Coordinates(x, y), new PointBuilder().coordinateX(x).coordinateY(y).build());
            }
        }
    }

    /**
     * Represents in a console the matrix with all the Points contained in it.
     */
    @Override
    public String toString() {

        StringBuilder strBuilder = new StringBuilder();

        for (int y = 0; y < height; y++) {
            strBuilder.append("|");
            for (int x = 0; x < width; x++) {
                strBuilder.append(matrix.get(new Coordinates(x, y)));
            }
            strBuilder.append("| " + y + "\n");
        }

        return strBuilder.toString();
    }
}
