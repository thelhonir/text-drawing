package org.thelhonir.drawing.command;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.thelhonir.drawing.canvas.Canvas;
import org.thelhonir.drawing.canvas.builder.CanvasBuilder;
import org.thelhonir.drawing.exception.InvalidCommandException;
import org.thelhonir.drawing.exception.InvalidLineException;
import org.thelhonir.drawing.point.Point;
import org.thelhonir.drawing.point.builder.PointBuilder;

public class CommandExecuterTest {

    @Test
    public void testCreateCanvasCommand() throws InvalidLineException, InvalidCommandException {
        CommandExecuter ce = new CommandExecuter();
        ce.setCommand(CreateCanvas.commandKey, new CreateCanvas(10, 10));

        Canvas expectedCanvas = new Canvas(10, 10);
        Canvas canvas = ce.executeCommand(CreateCanvas.commandKey);

        System.out.println("- Command CreateCanvas creates a correct canvas after execute command");
        assertEquals(expectedCanvas.getMatrix().size(), canvas.getMatrix().size());
    }

    @Test
    public void testDrawLineCommand() throws InvalidLineException, InvalidCommandException {
        CommandExecuter ce = new CommandExecuter();
        String expectedString = "|▓▓| 0\n|  | 1";
        Canvas canvas = new CanvasBuilder().withWidth(2).withHeight(2).build();
        Point from = new PointBuilder().build();
        Point to = new PointBuilder().coordinateX(1).coordinateY(0).build();

        ce.setCommand(DrawLine.commandKey, new DrawLine(canvas, from, to));

        canvas = ce.executeCommand(DrawLine.commandKey);

        System.out.println("- Command DrawLine returns a canvas with a drawn line from 0,0 to 0,1");

        System.out.println("EXPECTED CANVAS WITH LINE TO STRING GENERATED BY COMMAND");
        System.out.println(expectedString.trim());

        System.out.println("ACTUAL CANVAS WITH LINE TO STRING GENERATED BY COMMAND");
        System.out.println(canvas.toString().trim());

        assertEquals(expectedString.trim(), canvas.toString().trim());
    }

    @Test
    public void testDrawRectangleCommand() throws InvalidLineException, InvalidCommandException {
        CommandExecuter ce = new CommandExecuter();
        String expectedString = "|▓▓▓▓▓| 0\n|▓   ▓| 1\n|▓   ▓| 2\n|▓   ▓| 3\n|▓▓▓▓▓| 4";
        Canvas canvas = new CanvasBuilder().withWidth(5).withHeight(5).build();
        Point from = new PointBuilder().build();
        Point to = new PointBuilder().coordinateX(4).coordinateY(4).build();

        ce.setCommand(DrawRectangle.commandKey, new DrawRectangle(canvas, from, to));

        canvas = ce.executeCommand(DrawRectangle.commandKey);

        System.out.println("- Command DrawRectangle returns a canvas with a drawn rectangle from 0,0 to 4,4");

        System.out.println("EXPECTED CANVAS WITH RECTANGLE TO STRING GENERATED BY COMMAND");
        System.out.println(expectedString.trim());

        System.out.println("ACTUAL CANVAS WITH RECTANGLE TO STRING GENERATED BY COMMAND");
        System.out.println(canvas.toString().trim());

        assertEquals(expectedString.trim(), canvas.toString().trim());

    }

    @Test(expected = InvalidCommandException.class)

    public void testExecuteCommandThrowsInvalidCommandException() throws InvalidLineException, InvalidCommandException {
        CommandExecuter ce = new CommandExecuter();
        System.out
                .println("- ExecuteCommand should throw InvalidCommandException when an invalid command is submitted");
        ce.executeCommand("INVALID COMMAND");
    }

    @Test(expected = InvalidLineException.class)

    public void testExecuteCommandThrowsInvalidLineException() throws InvalidLineException, InvalidCommandException {
        CommandExecuter ce = new CommandExecuter();
        Canvas canvas = new CanvasBuilder().build();
        Point from = new PointBuilder().build();
        Point to = new PointBuilder().coordinateX(1).coordinateY(0).build();

        System.out.println("- ExecuteCommand should throw InvalidLineException when is not possible to create a Line");
        ce.setCommand(DrawLine.commandKey, new DrawLine(canvas, from, to));
        ce.executeCommand(DrawLine.commandKey);
    }
}