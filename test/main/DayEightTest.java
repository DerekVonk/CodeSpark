package main;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class DayEightTest {

    @Test
    public void getRegisterValue() {
        DayEight test = new DayEight("test/day8input_test.txt");

        HashMap<String, Long[]> testRegister = test.registers;
        for (String s : testRegister.keySet()) {
            assertEquals(1L, test.getRegisterValue(s));
        }
    }

    @Test
    public void getHighestRegisterValue() {
        DayEight puzzle = new DayEight("test/day8input.txt");
        puzzle.runInstructions();

        assertEquals(Long.valueOf(6828), puzzle.getHighestRegisterValue());
    }

    @Test
    public void getHighestRegisterHeldValue() {
        DayEight testTwo = new DayEight("test/day8input_test.txt");
        testTwo.runInstructions();

        assertEquals(Long.valueOf(10), testTwo.getHighestRegisterHeldValue());

        DayEight puzzleTwo = new DayEight("test/day8input.txt");
        puzzleTwo.runInstructions();

        assertEquals(Long.valueOf(7234), puzzleTwo.getHighestRegisterHeldValue());


    }
}