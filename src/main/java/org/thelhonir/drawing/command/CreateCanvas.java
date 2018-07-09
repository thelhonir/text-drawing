package org.thelhonir.drawing.command;

import org.thelhonir.drawing.canvas.Canvas;
import org.thelhonir.drawing.canvas.builder.CanvasBuilder;
import org.thelhonir.drawing.exception.InvalidLineException;

public class CreateCanvas implements Command {

    public static final String commandKey = "C";
    private int width;
    private int height;

    public CreateCanvas(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public Canvas execute() throws InvalidLineException {
        return new CanvasBuilder().withWidth(width).withHeight(height).build();
    }

}
