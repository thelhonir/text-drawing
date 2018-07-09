package org.thelhonir.drawing.point;

public enum RefPosition {
    UP, DOWN, RIGHT, RIGHT_UP, RIGHT_DOWN, LEFT, LEFT_UP, LEFT_DOWN;

    /**
     * TODO - Can we improve or simplify the references with just the orientations?
     */
    public static RefPosition getRefPositionByOrientation(Orientation orientation) {
        switch (orientation) {
        case HORIZONTAL_LEFT:
            return LEFT;
        case HORIZONTAL_RIGHT:
            return RIGHT;
        case VERTICAL_DOWN:
            return DOWN;
        case VERTICAL_UP:
            return UP;
        default:
            return null;
        }
    }
}
