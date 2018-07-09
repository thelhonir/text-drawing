package org.thelhonir.drawing;

import org.thelhonir.drawing.canvas.Canvas;
import org.thelhonir.drawing.canvas.builder.CanvasBuilder;
import org.thelhonir.drawing.drawer.Drawer;
import org.thelhonir.drawing.point.builder.PointBuilder;


public class App {
    public static void main(String[] args) {

        Canvas canvas = new CanvasBuilder().withWidth(60).withHeight(30).build();

        while (true) {

            System.out.println(canvas.toString());

            int fromX = Integer.parseInt(System.console().readLine("Enter from X "));

            int fromY = Integer.parseInt(System.console().readLine("Enter from Y "));

            int toX = Integer.parseInt(System.console().readLine("Enter to X "));

            int toY = Integer.parseInt(System.console().readLine("Enter to Y "));

            Drawer.drawRectangle(canvas, 
            new PointBuilder().coordinateX(fromX).coordinateY(fromY).build(), 
            new PointBuilder().coordinateX(toX).coordinateY(toY).build());

        
        }
    }
}
