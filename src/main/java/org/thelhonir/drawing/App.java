package org.thelhonir.drawing;

import java.util.List;

import org.thelhonir.drawing.canvas.Canvas;
import org.thelhonir.drawing.canvas.builder.CanvasBuilder;
import org.thelhonir.drawing.command.CommandExecuter;
import org.thelhonir.drawing.command.CreateCanvas;
import org.thelhonir.drawing.command.DrawLine;
import org.thelhonir.drawing.command.DrawRectangle;
import org.thelhonir.drawing.exception.InvalidCommandException;
import org.thelhonir.drawing.exception.InvalidLineException;
import org.thelhonir.drawing.point.builder.PointBuilder;
import org.thelhonir.drawing.util.Util;

public class App {

    public static void main(String[] args) {

        Canvas canvas = new CanvasBuilder().build();
        CommandExecuter commandExecuter = new CommandExecuter();

        while (true) {
            try {
                System.out.println(canvas.toString());
                String[] splittedCommand = System.console().readLine("Enter command: ").split(" ");
                List<Integer> integers;
                integers = Util.getIntegersFromCommand(splittedCommand);

                switch (splittedCommand[0].toUpperCase()) {
                case CreateCanvas.commandKey:
                    CreateCanvas createCanvas = new CreateCanvas(integers.get(0), integers.get(1));
                    commandExecuter.setCommand(CreateCanvas.commandKey, createCanvas);
                    break;
                case DrawLine.commandKey:
                    DrawLine drawLine = new DrawLine(canvas,
                            new PointBuilder().coordinateX(integers.get(0)).coordinateY(integers.get(1)).build(),
                            new PointBuilder().coordinateX(integers.get(2)).coordinateY(integers.get(3)).build());
                    commandExecuter.setCommand(DrawLine.commandKey, drawLine);
                    break;
                case DrawRectangle.commandKey:
                    DrawRectangle drawRectangle = new DrawRectangle(canvas,
                            new PointBuilder().coordinateX(integers.get(0)).coordinateY(integers.get(1)).build(),
                            new PointBuilder().coordinateX(integers.get(2)).coordinateY(integers.get(3)).build());
                    commandExecuter.setCommand(DrawRectangle.commandKey, drawRectangle);
                    break;
                case "Q":
                    System.exit(0);
                    break;
                default:
                    throw new InvalidCommandException(splittedCommand[0]);
                }

                canvas = commandExecuter.executeCommand(splittedCommand[0]);

            } catch (IndexOutOfBoundsException exception) {
                System.out.println("INVALID COMMAND: Some args are missing.");
            } catch (NumberFormatException exception) {
                System.out.println("INVALID COMMAND: Some args are not valid.");
            } catch (InvalidLineException exception) {
                System.out.println(exception.getMessage());
            } catch (InvalidCommandException exception) {
                System.out.println(exception.getMessage());
            }
        }

    }
}
