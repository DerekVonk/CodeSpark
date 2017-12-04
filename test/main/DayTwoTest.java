package main;

import org.junit.Test;

import static org.junit.Assert.*;

public class DayTwoTest {

    @Test
    public void calculateFirstChecksum() {
        DayTwo test1 = new DayTwo("corruptionChecksumTest.txt");
        assertEquals(18, test1.calculateFirstChecksum());
    }
}