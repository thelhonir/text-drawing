package org.thelhonir.drawing.point;

public enum Orientation {
    HORIZONTAL_LEFT, HORIZONTAL_RIGHT, VERTICAL_UP, VERTICAL_DOWN;

    /**
     * TODO - Refactor this function to get the orientation from a Coordinates
     * comparator.
     */
    public static Orientation getOrientation(Point from, Point to) {
        if (from.getCoordinates().getX() == to.getCoordinates().getX()) {
            if (from.getCoordinates().getY() < to.getCoordinates().getY()) {
                return HORIZONTAL_RIGHT;
            } else {
                return HORIZONTAL_LEFT;
            }
        } else {
            if (from.getCoordinates().getX() < to.getCoordinates().getX()) {
                return VERTICAL_DOWN;
            } else {
                return VERTICAL_UP;
            }
        }
    }
}
