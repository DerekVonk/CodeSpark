package main;

import org.junit.Test;

import static org.junit.Assert.*;

public class EnglishBeggarsTest {

    @Test
    public void beggars() {
        // Basic tests
        int[] test = {1, 2, 3, 4, 5};
        int[] a1 = {15}, a2 = {9, 6}, a3 = {5, 7, 3}, a4 = {1, 2, 3, 4, 5, 0}, a5 = {};
        assertArrayEquals(EnglishBeggars.beggars(test, 1), a1);
        assertArrayEquals(EnglishBeggars.beggars(test, 2), a2);
        assertArrayEquals(EnglishBeggars.beggars(test, 3), a3);
        assertArrayEquals(EnglishBeggars.beggars(test, 6), a4);
        assertArrayEquals(EnglishBeggars.beggars(test, 0), a5);
    }
}