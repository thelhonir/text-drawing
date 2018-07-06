package org.thelhonir.drawing;

import org.thelhonir.drawing.canvas.Canvas;
import org.thelhonir.drawing.canvas.builder.CanvasBuilder;
import org.thelhonir.drawing.shape.Line;
import org.thelhonir.drawing.shape.Point;
import org.thelhonir.drawing.shape.builder.LineBuilder;
import org.thelhonir.drawing.shape.builder.PointBuilder;

public class App {
    public static void main(String[] args) {
        try {
            System.out.println("Hello World!");
            Canvas canvas = new CanvasBuilder().withHeight(4).withWidth(4).build();

            System.out.println(canvas.getDrawingArea()[0][3].isVisible());

            canvas.getDrawingArea()[0][3].setVisibility(true);

            System.out.println(canvas.getDrawingArea()[0][3].isVisible());

            // TODO check this line builder!
            Point from = new PointBuilder().coordinateX(1).coordinateY(5).build();
            Point to = new PointBuilder().coordinateX(0).coordinateY(50).build();
            Line line;

            line = new LineBuilder().from(from).to(to).build();
            System.out.println(line.getLine().size());
            System.out.println(line.getLiOrientation());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
