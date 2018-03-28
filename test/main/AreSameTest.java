package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AreSameTest {

    @Test
    void testHappyFlow() {
        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};
        assertEquals(AreSame.comp(a, b), true);
    }

    @Test
    void testOneEmptyArray() {
        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = new int[]{};
        assertEquals(AreSame.comp(a, b), false);
    }

    @Test
    void testOtherEmptyArray() {
        int[] a = new int[]{};
        int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};
        assertEquals(AreSame.comp(a, b), false);
    }

    @Test
    void testOneArrayDiffersInLength() {
        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736};
        assertEquals(AreSame.comp(a, b), false);
    }

    @Test
    void testOneArrayElementIsNotSquareOfAnyNumberInOtherArray1() {
        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = new int[]{132, 14641, 20736, 361, 25921, 361, 20736, 361};
        assertEquals(AreSame.comp(a, b), false);
    }

    @Test
    void testOneArrayElementIsNotSquareOfAnyNumberInOtherArray2() {
        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = new int[]{121, 14641, 20736, 36100, 25921, 361, 20736, 361};
        assertEquals(AreSame.comp(a, b), false);
    }

}