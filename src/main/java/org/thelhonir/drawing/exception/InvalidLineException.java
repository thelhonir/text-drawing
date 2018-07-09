package org.thelhonir.drawing.exception;

public class InvalidLineException extends Exception {

    private static final long serialVersionUID = -8165829626416431773L;
	private static final String errorMessage = "POINTS DON'T CREATE A VALID LINE";

    public InvalidLineException() {
        super(errorMessage);
    }

}
