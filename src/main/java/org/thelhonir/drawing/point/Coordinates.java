package org.thelhonir.drawing.point;

import java.util.Objects;

public class Coordinates {

    private final int x;
    private final int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (!(obj instanceof Coordinates)) {
            return false;
        }

        Coordinates coor = (Coordinates) obj;

        return this.x == coor.x && this.y == coor.y;
    }

}
