package org.thelhonir.drawing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.thelhonir.drawing.canvas.Canvas;
import org.thelhonir.drawing.canvas.builder.CanvasBuilder;
import org.thelhonir.drawing.drawer.Drawer;
import org.thelhonir.drawing.exception.InvalidLineException;
import org.thelhonir.drawing.point.builder.PointBuilder;

public class App {

    public static void main(String[] args) {

        Canvas canvas = new CanvasBuilder().build();

        while (true) {
            try {
                System.out.println(canvas.toString());
                String[] splittedCommand = System.console().readLine("Enter command: ").split(" ");
                List<Integer> integers;
                switch (splittedCommand[0].toUpperCase()) {
                case "C":
                    integers = getIntegersFromCommand(splittedCommand);
                    canvas = new CanvasBuilder().withWidth(integers.get(0) + 1).withHeight(integers.get(1) + 1).build();
                    break;
                case "L":
                    integers = getIntegersFromCommand(splittedCommand);

                    canvas = Drawer.drawLine(canvas,
                            new PointBuilder().coordinateX(integers.get(0)).coordinateY(integers.get(1)).build(),
                            new PointBuilder().coordinateX(integers.get(2)).coordinateY(integers.get(3)).build());
                    break;
                case "R":
                    integers = getIntegersFromCommand(splittedCommand);

                    canvas = Drawer.drawRectangle(canvas,
                            new PointBuilder().coordinateX(integers.get(0)).coordinateY(integers.get(1)).build(),
                            new PointBuilder().coordinateX(integers.get(2)).coordinateY(integers.get(3)).build());
                    break;
                case "Q":
                    System.exit(0);
                    break;
                default:
                    System.out.printf("NOT A VALID COMMAND: The command %s doesn't exist.\n", splittedCommand[0]);
                }
            } catch (IndexOutOfBoundsException exception) {
                System.out.println("NOT A VALID COMMAND: Some args are missing.");
            } catch (NumberFormatException exception) {
                System.out.println("NOT A VALID COMMAND: Some args are not valid.");
            } catch (InvalidLineException exception) {
                System.out.println(exception.getMessage());
            }
        }

    }

    private static List<Integer> getIntegersFromCommand(String[] splittedCommand) {
        List<Integer> integers = new ArrayList<Integer>();
        for (String commandPart : Arrays.copyOfRange(splittedCommand, 1, splittedCommand.length)) {
            integers.add(Integer.parseInt(commandPart));
        }
        return integers;
    }
}
