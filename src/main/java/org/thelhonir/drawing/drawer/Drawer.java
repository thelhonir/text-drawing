package org.thelhonir.drawing.drawer;

import org.thelhonir.drawing.canvas.Canvas;
import org.thelhonir.drawing.exception.InvalidLineException;
import org.thelhonir.drawing.point.Orientation;
import org.thelhonir.drawing.point.Point;
import org.thelhonir.drawing.point.RefPosition;
import org.thelhonir.drawing.point.builder.PointBuilder;

public class Drawer {

    /**
     * Draws (sets to visible true) recursively the points between 2 points of a
     * canvas.
     * @throws InvalidLineException
     */
    public static Canvas drawLine(Canvas canvas, Point from, Point to) throws InvalidLineException {
        try {
            canvas.getMatrix().get(from.getCoordinates()).setVisibility(true);

            Point nextPoint = canvas.getMatrix()
                    .get(from.getNeighbourCoordinates().get(getNodeRefPosition(getLineOrientation(from, to))));

            nextPoint.setVisibility(true);

            if (!nextPoint.getCoordinates().equals(to.getCoordinates())) {
                canvas = drawLine(canvas, nextPoint, to);
            }

            return canvas;
        } catch (NullPointerException exception) {
            throw new InvalidLineException();
        }
    }

    /**
     * Obtains fromPrime and toPrime points and draws the lines between the 4
     * points.
     * @throws InvalidLineException
     */
    public static Canvas drawRectangle(Canvas canvas, Point from, Point to) throws InvalidLineException {

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

    private static Orientation getLineOrientation(Point from, Point to) {
        return Orientation.getOrientation(from, to);
    }

    /**
     * Gets the next node reference position based on the line orientation.
     */
    private static RefPosition getNodeRefPosition(Orientation orientation) {
        return RefPosition.getRefPositionByOrientation(orientation);
    }

}
