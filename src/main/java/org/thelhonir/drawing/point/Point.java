package org.thelhonir.drawing.point;

import java.util.HashMap;

public class Point {
    private boolean visible;
    private Coordinates coordinates;
    private HashMap<Orientation, Coordinates> neighbourCoordinates = new HashMap<Orientation, Coordinates>();;

    public Point(Coordinates coordinates, boolean visible) {
        this.coordinates = coordinates;
        this.visible = visible;
        buildNeighbourCoordinates();
    }

    public boolean isVisible() {
        return this.visible;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public HashMap<Orientation, Coordinates> getNeighbourCoordinates() {
        return this.neighbourCoordinates;
    }

    public void setVisibility(boolean visible) {
        this.visible = visible;
    }

    /**
     * Set coordinates for adjacent nodes (Point). Notice that we only use for this
     * case adjacent nodes in vertical or horizontal relationships
     */
    private void buildNeighbourCoordinates() {
        neighbourCoordinates.put(Orientation.UP, new Coordinates(coordinates.getX() - 1, coordinates.getY()));
        neighbourCoordinates.put(Orientation.LEFT, new Coordinates(coordinates.getX(), coordinates.getY() - 1));
        neighbourCoordinates.put(Orientation.RIGHT, new Coordinates(coordinates.getX(), coordinates.getY() + 1));
        neighbourCoordinates.put(Orientation.DOWN, new Coordinates(coordinates.getX() + 1, coordinates.getY()));
    }

    @Override
    public String toString() {
        return visible ? "▓" : " ";
    }
}
