package org.thelhonir.drawing.drawer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.thelhonir.drawing.canvas.Canvas;
import org.thelhonir.drawing.canvas.builder.CanvasBuilder;
import org.thelhonir.drawing.exception.InvalidLineException;
import org.thelhonir.drawing.point.Point;
import org.thelhonir.drawing.point.builder.PointBuilder;

public class DrawerTest {

    @Test
    public void testDrawHorizontalLine() throws InvalidLineException {
        String expectedString = "|▓▓| 0\n|  | 1";

        Canvas canvas = new CanvasBuilder().withWidth(2).withHeight(2).build();

        Point from = new PointBuilder().build();
        Point to = new PointBuilder().coordinateX(1).coordinateY(0).build();

        canvas = Drawer.drawLine(canvas, from, to);

        System.out.println("- Drawer returns a canvas with a drawn line from 0,0 to 1,0");

        System.out.println("EXPECTED CANVAS WITH LINE TO STRING");
        System.out.println(expectedString.trim());

        System.out.println("ACTUAL CANVAS WITH LINE TO STRING");
        System.out.println(canvas.toString().trim());

        assertEquals(expectedString.trim(), canvas.toString().trim());
    }

    @Test
    public void testDrawVerticalLine() throws InvalidLineException {
        String expectedString = "|▓ | 0\n|▓ | 1";

        Canvas canvas = new CanvasBuilder().withWidth(2).withHeight(2).build();

        Point from = new PointBuilder().build();
        Point to = new PointBuilder().coordinateX(0).coordinateY(1).build();

        canvas = Drawer.drawLine(canvas, from, to);

        System.out.println("- Drawer returns a canvas with a drawn line from 0,0 to 0,1");

        System.out.println("EXPECTED CANVAS WITH LINE TO STRING");
        System.out.println(expectedString.trim());

        System.out.println("ACTUAL CANVAS WITH LINE TO STRING");
        System.out.println(canvas.toString().trim());

        assertEquals(expectedString.trim(), canvas.toString().trim());
    }

    @Test
    public void testDrawRectangle() throws InvalidLineException {
        String expectedString = "|▓▓▓▓▓| 0\n|▓   ▓| 1\n|▓   ▓| 2\n|▓   ▓| 3\n|▓▓▓▓▓| 4";

        Canvas canvas = new CanvasBuilder().withWidth(5).withHeight(5).build();

        Point from = new PointBuilder().build();
        Point to = new PointBuilder().coordinateX(4).coordinateY(4).build();

        canvas = Drawer.drawRectangle(canvas, from, to);

        System.out.println("- Drawer returns a canvas with a drawn rectangle from 0,0 to 4,4");

        System.out.println("EXPECTED CANVAS WITH RECTANGLE TO STRING");
        System.out.println(expectedString.trim());

        System.out.println("ACTUAL CANVAS WITH RECTANGLE TO STRING");
        System.out.println(canvas.toString().trim());

        assertEquals(expectedString.trim(), canvas.toString().trim());
    }

    @Test(expected = InvalidLineException.class)
    public void testDrawLineThrowsException() throws InvalidLineException {

        Canvas canvas = new CanvasBuilder().withWidth(2).withHeight(2).build();

        Point from = new PointBuilder().build();
        Point to = new PointBuilder().coordinateX(1).coordinateY(10).build();

        System.out.println("- Drawer should throw InvalidLineException on an incorrect point");
        canvas = Drawer.drawLine(canvas, from, to);

    }
}
