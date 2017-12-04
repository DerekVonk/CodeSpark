package main;

import org.junit.Test;

import static org.junit.Assert.*;

public class DayOneTest {

    @Test
    public void calculateSum() {
        DayOne test1 = new DayOne("1122");
        assertEquals(3, test1.calculateSum());

        DayOne test2 = new DayOne("1111");
        assertEquals(4, test2.calculateSum());

        DayOne test3 = new DayOne("1234");
        assertEquals(0, test3.calculateSum());

        DayOne test4 = new DayOne("91212129");
        assertEquals(9, test4.calculateSum());
    }

    @Test
    public void calculateSecondSum() {
        DayOne test1 = new DayOne("1212");
        assertEquals(6, test1.calculateSecondSum());

        DayOne test2 = new DayOne("1221");
        assertEquals(0, test2.calculateSecondSum());

        DayOne test3 = new DayOne("123425");
        assertEquals(4, test3.calculateSecondSum());

        DayOne test4 = new DayOne("123123");
        assertEquals(12, test4.calculateSecondSum());

        DayOne test5 = new DayOne("12131415");
        assertEquals(4, test5.calculateSecondSum());
    }
}