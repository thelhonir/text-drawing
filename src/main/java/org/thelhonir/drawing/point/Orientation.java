package org.thelhonir.drawing.point;

public enum Orientation {
    LEFT, RIGHT, UP, DOWN, NONE;

    /**
     * Returns the orientation between 2 nodes based on the coordinates
     * 
     * TODO refactor this to get this orientation from a Coordinates comparator
     */
    public static Orientation getOrientation(Point from, Point to) {
        if (from.getCoordinates().getX() == to.getCoordinates().getX()) {
            if (from.getCoordinates().getY() < to.getCoordinates().getY()) {
                return RIGHT;
            } else if(from.getCoordinates().getY() > to.getCoordinates().getY()){
                return LEFT;
            }
        } else {
            if (from.getCoordinates().getX() < to.getCoordinates().getX()) {
                return DOWN;
            } else  if (from.getCoordinates().getX() > to.getCoordinates().getX()){
                return UP;
            }
        }
        return NONE;
    }
}
