package org.thelhonir.drawing.point;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.thelhonir.drawing.point.builder.PointBuilder;

public class OrientationTest {

    @Test
    public void testGetRightOrientation() {

        Point from = new PointBuilder().build();
        Point to = new PointBuilder().coordinateX(0).coordinateY(1).build();

        System.out.println("- Orientation should return RIGHT");
        assertEquals(Orientation.RIGHT, Orientation.getOrientation(from, to));
    }

    @Test
    public void testGetLeftOrientation() {

        Point from = new PointBuilder().build();
        Point to = new PointBuilder().coordinateX(0).coordinateY(-1).build();

        System.out.println("- Orientation should return LEFT");
        assertEquals(Orientation.LEFT, Orientation.getOrientation(from, to));
    }

    @Test
    public void testGetUpOrientation() {

        Point from = new PointBuilder().build();
        Point to = new PointBuilder().coordinateX(-1).coordinateY(0).build();

        System.out.println("- Orientation should return UP");
        assertEquals(Orientation.UP, Orientation.getOrientation(from, to));
    }

    @Test
    public void testGetDownOrientation() {

        Point from = new PointBuilder().build();
        Point to = new PointBuilder().coordinateX(1).coordinateY(0).build();

        System.out.println("- Orientation should return DOWN");
        assertEquals(Orientation.DOWN, Orientation.getOrientation(from, to));
    }

    @Test
    public void testGetNoneOrientation() {

        Point from = new PointBuilder().build();
        Point to = new PointBuilder().build();

        System.out.println("- Orientation should return NONE");
        assertEquals(Orientation.NONE, Orientation.getOrientation(from, to));
    }
}
