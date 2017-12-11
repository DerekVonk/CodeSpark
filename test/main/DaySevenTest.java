package main;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class DaySevenTest {

    @Test
    public void checkBaseProgramName() throws IOException {
        DaySeven test = new DaySeven("test/day7input_test.txt");
        assertEquals("tknk", test.getBaseProgram().getName());

        DaySeven puzzle = new DaySeven("test/day7input.txt");
        assertEquals("tbfce", puzzle.getBaseProgram().getName());
    }

}