package org.thelhonir.drawing.canvas;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;
import org.thelhonir.drawing.canvas.builder.CanvasBuilder;
import org.thelhonir.drawing.point.Coordinates;
import org.thelhonir.drawing.point.Point;
import org.thelhonir.drawing.point.builder.PointBuilder;

public class CanvasTest {

    @Test
    public void testBuilderCreatesMatrix() {

        HashMap<Coordinates, Point> expectedMatrix = new HashMap<Coordinates, Point>();

        expectedMatrix.put(new Coordinates(0, 0), new PointBuilder().coordinateX(0).coordinateY(0).build());
        expectedMatrix.put(new Coordinates(0, 1), new PointBuilder().coordinateX(0).coordinateY(1).build());
        expectedMatrix.put(new Coordinates(1, 0), new PointBuilder().coordinateX(1).coordinateY(0).build());
        expectedMatrix.put(new Coordinates(1, 1), new PointBuilder().coordinateX(1).coordinateY(1).build());

        Canvas canvas = new CanvasBuilder().withWidth(2).withHeight(2).build();

        System.out.println("- Canvas builder creates the matrix with the correct size");
        assertEquals(expectedMatrix.size(), canvas.getMatrix().size());

        System.out.println("- Canvas builder fills the matrix with the correct coordinates and points");
        assertEquals(expectedMatrix.keySet(), canvas.getMatrix().keySet());
    }

    @Test
    public void testCanvasPrintsDrawableArea() {
        String expectedString = "|  | 0\n|  | 1";

        Canvas canvas = new CanvasBuilder().withWidth(2).withHeight(2).build();

        System.out.println("- Canvas prints rows and columns correctly when toString() is called");

        System.out.println("EXPECTED CANVAS TO STRING");
        System.out.println(expectedString.trim());

        System.out.println("ACTUAL CANVAS TO STRING");
        System.out.println(canvas.toString().trim());

        assertEquals(expectedString.trim(), canvas.toString().trim());
    }

}
