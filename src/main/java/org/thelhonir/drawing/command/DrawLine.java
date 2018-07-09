package org.thelhonir.drawing.command;

import org.thelhonir.drawing.canvas.Canvas;
import org.thelhonir.drawing.drawer.Drawer;
import org.thelhonir.drawing.exception.InvalidLineException;
import org.thelhonir.drawing.point.Point;

public class DrawLine implements Command {

    public static final String commandKey = "L";
    private Canvas canvas;
    private Point from;
    private Point to;

    public DrawLine(Canvas canvas, Point from, Point to) {
        this.canvas = canvas;
        this.from = from;
        this.to = to;
    }

    @Override
    public Canvas execute() throws InvalidLineException {
        return Drawer.drawLine(canvas, from, to);
    }

}
