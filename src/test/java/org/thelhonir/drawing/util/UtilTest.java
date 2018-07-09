package org.thelhonir.drawing.util;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class UtilTest{
    
    @Test
    public void getIntegersFromCommand(){
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(2);
        String[] stringNumbers = {"0","1","2"};

        System.out.println("- Util class parses a set of strings to integer");
        assertEquals(expected, Util.getIntegersFromCommand(stringNumbers));
    }
}
