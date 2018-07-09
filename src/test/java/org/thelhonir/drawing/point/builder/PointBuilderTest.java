package org.thelhonir.drawing.point.builder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.thelhonir.drawing.point.Coordinates;
import org.thelhonir.drawing.point.Point;

public class PointBuilderTest {

    @Test
    public void testBuilderCreatesCorrectInstance() {
        Point expected = new Point(new Coordinates(0, 0), false);

        Point actual = new PointBuilder().build();
        
        System.out.println("- Builder creates a Point at 0,0 Coordinates");
        assertEquals(expected.getCoordinates(), actual.getCoordinates());
    }
}
