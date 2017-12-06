package main;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DayThreeTest {

    @Test
    public void getShortestPath() {
        DayThree test1 = new DayThree(515);
        assertEquals(0, test1.getShortestPath(1));
        assertEquals(3, test1.getShortestPath(12));
        assertEquals(2, test1.getShortestPath(23));
        assertEquals(31, test1.getShortestPath(1024));
        assertEquals(438, test1.getShortestPath(265149));
    }

    @Test
    public void getShortestPathThrows() {
        DayThree test2 = new DayThree(5);

        try {
            assertEquals(31, test2.getShortestPath(1024));
        } catch (NullPointerException e) {
            assertThat(e.getMessage(), is("Value 1024 doesn't exist in this array"));
        }
    }

}