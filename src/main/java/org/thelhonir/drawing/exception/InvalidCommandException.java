package org.thelhonir.drawing.exception;

public class InvalidCommandException extends Exception {

    private static final long serialVersionUID = 8714255747603670688L;

    public InvalidCommandException(String command) {
        super(String.format("COMMAND %s IS NOT VALID", command));
    }

}
