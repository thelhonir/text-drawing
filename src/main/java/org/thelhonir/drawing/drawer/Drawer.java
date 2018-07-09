package org.thelhonir.drawing.drawer;

import org.thelhonir.drawing.canvas.Canvas;
import org.thelhonir.drawing.point.Orientation;
import org.thelhonir.drawing.point.Point;
import org.thelhonir.drawing.point.RefPosition;
import org.thelhonir.drawing.point.builder.PointBuilder;

public class Drawer {

    /**
     * Draws (sets to visible true) recursively the points between 2 points of a
     * canvas.
     */
    public static Canvas drawLine(Canvas canvas, Point from, Point to) {
        canvas.getMatrix().get(from.getCoordinates()).setVisibility(true);
        Orientation lineOrientation = Orientation.getOrientation(from, to);
        RefPosition refPosition = RefPosition.getRefPositionByOrientation(lineOrientation);
        Point nextPoint = canvas.getMatrix().get(from.getNeighbourCoordinates().get(refPosition));
        if (!nextPoint.getCoordinates().equals(to.getCoordinates())) {
            canvas = drawLine(canvas, nextPoint, to);
        }

        return canvas;
    }

    /**
     * Obtains fromPrime and toPrime points and draws the lines between the 4
     * points.
     */
    public static Canvas drawRectangle(Canvas canvas, Point from, Point to) {

        Point fromPrime = buildPoint(from.getCoordinates().getX(), to.getCoordinates().getY());

        Point toPrime = buildPoint(to.getCoordinates().getX(), from.getCoordinates().getY());

        canvas = drawLine(canvas, from, fromPrime);

        canvas = drawLine(canvas, to, toPrime);

        canvas = drawLine(canvas, toPrime, from);

        canvas = drawLine(canvas, fromPrime, to);

        return canvas;
    }

    private static Point buildPoint(int x, int y) {
        return new PointBuilder().coordinateX(x).coordinateY(y).build();
    }

}
