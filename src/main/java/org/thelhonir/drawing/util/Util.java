package org.thelhonir.drawing.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {
    public static List<Integer> getIntegersFromCommand(String[] splittedCommand) {
        List<Integer> integers = new ArrayList<Integer>();
        for (String commandPart : Arrays.copyOfRange(splittedCommand, 1, splittedCommand.length)) {
            integers.add(Integer.parseInt(commandPart));
        }
        return integers;
    }
}
