package org.thelhonir.drawing.command;

import org.thelhonir.drawing.canvas.Canvas;
import org.thelhonir.drawing.drawer.Drawer;
import org.thelhonir.drawing.exception.InvalidLineException;
import org.thelhonir.drawing.point.Point;

public class DrawRectangle implements Command {

    public static final String commandKey = "R";
    private Canvas canvas;
    private Point from;
    private Point to;

    public DrawRectangle(Canvas canvas, Point from, Point to) {
        this.canvas = canvas;
        this.from = from;
        this.to = to;
    }

    @Override
    public Canvas execute() throws InvalidLineException {
        return Drawer.drawRectangle(canvas, from, to);
    }

}
