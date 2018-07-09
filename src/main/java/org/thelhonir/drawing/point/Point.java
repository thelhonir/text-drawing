package org.thelhonir.drawing.point;

import java.util.HashMap;

public class Point {
    private boolean visible;
    private Coordinates coordinates;
    private HashMap<RefPosition, Coordinates> neighbourCoordinates = new HashMap<RefPosition, Coordinates>();;

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

    public HashMap<RefPosition, Coordinates> getNeighbourCoordinates() {
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
        neighbourCoordinates.put(RefPosition.LEFT_UP, new Coordinates(coordinates.getX() - 1, coordinates.getY() - 1));
        neighbourCoordinates.put(RefPosition.UP, new Coordinates(coordinates.getX() - 1, coordinates.getY()));
        neighbourCoordinates.put(RefPosition.RIGHT_UP, new Coordinates(coordinates.getX() - 1, coordinates.getY() + 1));
        neighbourCoordinates.put(RefPosition.LEFT, new Coordinates(coordinates.getX(), coordinates.getY() - 1));
        neighbourCoordinates.put(RefPosition.RIGHT, new Coordinates(coordinates.getX(), coordinates.getY() + 1));
        neighbourCoordinates.put(RefPosition.LEFT_DOWN,
                new Coordinates(coordinates.getX() + 1, coordinates.getY() - 1));
        neighbourCoordinates.put(RefPosition.DOWN, new Coordinates(coordinates.getX() + 1, coordinates.getY()));
        neighbourCoordinates.put(RefPosition.RIGHT_DOWN,
                new Coordinates(coordinates.getX() + 1, coordinates.getY() + 1));
    }

    @Override
    public String toString() {
        return visible ? "▓" : " ";
    }
}
