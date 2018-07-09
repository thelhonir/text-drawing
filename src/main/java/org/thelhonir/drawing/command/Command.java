package org.thelhonir.drawing.command;

import org.thelhonir.drawing.canvas.Canvas;
import org.thelhonir.drawing.exception.InvalidLineException;

public interface Command {
    public Canvas execute() throws InvalidLineException;
}
