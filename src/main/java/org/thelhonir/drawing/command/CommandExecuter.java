package org.thelhonir.drawing.command;

import java.util.HashMap;

import org.thelhonir.drawing.canvas.Canvas;
import org.thelhonir.drawing.exception.InvalidCommandException;
import org.thelhonir.drawing.exception.InvalidLineException;

public class CommandExecuter {
    HashMap<String, Command> commands = new HashMap<String, Command>();

    public void setCommand(String commandKey, Command command) {
        commands.put(commandKey.toUpperCase(), command);
    }

    public Canvas executeCommand(String commandKey) throws InvalidLineException, InvalidCommandException {
        try {
            return commands.get(commandKey.toUpperCase()).execute();
        } catch (NullPointerException exception) {
            throw new InvalidCommandException(commandKey);
        }
    }
}
