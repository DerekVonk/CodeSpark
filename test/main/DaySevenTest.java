package main;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class DaySevenTest {

    @Test
    public void checkBaseProgramName() throws IOException {
        DaySeven test = new DaySeven("test/day7input_test.txt");
        try {
            assertEquals("tknk", test.getBaseProgram());
        } catch (Exception e) {
            e.printStackTrace();
        }

        DaySeven puzzle = new DaySeven("test/day7input.txt");
        try {
            assertEquals("eugwuhl", puzzle.getBaseProgram());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}