package main;

import org.junit.Test;

import static org.junit.Assert.*;

public class DayFiveTest {

    @Test
    public void countJumps() {
        DayFive test = new DayFive("test/day5input_test.txt");
        assertEquals(5, test.instructions.length);
        assertEquals(10, test.countJumps());

//        DayFive test1 = new DayFive("day5input_test2.txt");
//        assertEquals(5, test1.instructions.length);
//        assertEquals(5, test1.countJumps());
//

        DayFive test2 = new DayFive("test/day5input.txt");
        assertEquals(1097, test2.instructions.length);
//        assertEquals(396086, test2.countJumps());
        assertEquals(28675390, test2.countJumps()); // for part 2 of day five
    }
}