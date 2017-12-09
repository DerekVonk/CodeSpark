package main;

import org.junit.Test;

import static org.junit.Assert.*;

public class DaySixTest {

    @Test
    public void getRedistributionCycles() {
        DaySix test = new DaySix(0,2,7,0);
        assertEquals(5 , test.getRedistributionCycles());
        assertEquals(4, test.getLoopCycles());


        DaySix puzzle = new DaySix(4, 1, 15, 12, 0, 9, 9, 5, 5,	8, 7, 3, 14, 5,	12,	3);
        assertEquals(6681 , puzzle.getRedistributionCycles());
        assertEquals(2392, puzzle.getLoopCycles());

    }
}