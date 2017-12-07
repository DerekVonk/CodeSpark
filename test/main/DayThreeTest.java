package main;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DayThreeTest {

    @Test
    public void getShortestPath() {
        DayThree test = new DayThree(515);
        assertEquals(0, test.getShortestPath(1));
        assertEquals(3, test.getShortestPath(12));
        assertEquals(2, test.getShortestPath(23));
        assertEquals(31, test.getShortestPath(1024));
        assertEquals(438, test.getShortestPath(265149));
    }

    @Test
    public void getShortestPathThrows() {
        DayThree test = new DayThree(5);

        try {
            assertEquals(31, test.getShortestPath(1024));
        } catch (NullPointerException e) {
            assertThat(e.getMessage(), is("Value 1024 doesn't exist in this array"));
        }
    }

    @Test
    public void getFirstValueLarger() {
        DayThree test = new DayThree(5);
        assertEquals(4, test.getFirstValueLarger(2));
//        assertEquals(5, test.getFirstValueLarger(4));
//        assertEquals(11, test.getFirstValueLarger(10));
//        assertEquals(59, test.getFirstValueLarger(57));
//        assertEquals(70, test.getFirstValueLarger(265149));
    }

}