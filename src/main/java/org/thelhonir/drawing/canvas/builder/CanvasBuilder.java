package org.thelhonir.drawing.canvas.builder;

import org.thelhonir.drawing.canvas.Canvas;

public class CanvasBuilder {
    private int width = 0;
    private int height = 0;

    public CanvasBuilder withWidth(int width) {
        this.width = width;
        return this;
    }

    public CanvasBuilder withHeight(int height) {
        this.height = height;
        return this;
    }

    public Canvas build() {
        return new Canvas(this.width, this.height);
    }

}
