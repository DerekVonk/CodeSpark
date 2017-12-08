package main;

import org.junit.Test;

import static org.junit.Assert.*;

public class DaySixTest {

    @Test
    public void getRedistributionCycles() {
        DaySix test = new DaySix(0,2,7,0);
        assertEquals(5 , test.getRedistributionCycles());
    }
}