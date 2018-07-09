package org.thelhonir.drawing.point;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;
import org.thelhonir.drawing.point.builder.PointBuilder;

public class PointTest {

    @Test
    public void testBuilderCreatesNeighbours() {
        HashMap<Orientation, Coordinates> expectedNeighboursMap = new HashMap<Orientation, Coordinates>();

        expectedNeighboursMap.put(Orientation.DOWN, new Coordinates(1, 0));
        expectedNeighboursMap.put(Orientation.UP, new Coordinates(-1, 0));
        expectedNeighboursMap.put(Orientation.RIGHT, new Coordinates(0, 1));
        expectedNeighboursMap.put(Orientation.LEFT, new Coordinates(0, -1));
        expectedNeighboursMap.put(Orientation.NONE, new Coordinates(0, 0));

        Point point = new PointBuilder().coordinateX(0).coordinateY(0).build();

        System.out.println("- Point builder generates neighbours correctly on creation");
        assertEquals(expectedNeighboursMap.entrySet(), point.getNeighbourCoordinates().entrySet());
    }

    @Test
    public void testPointPrintsCharacterOnVisible() {
        String expectedVisible = "▓";
        String expectedInvisible = " ";

        Point point = new PointBuilder().coordinateX(0).coordinateY(0).build();

        System.out.println("- Point prints blank character when visible false");
        assertEquals(point.toString(), expectedInvisible);

        point.setVisibility(true);

        System.out.println("- Point prints ▓ character when visible true");
        assertEquals(point.toString(), expectedVisible);
    }

}
