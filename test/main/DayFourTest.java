package main;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DayFourTest {

    @Test
    public void isValidPassphrase() {
        DayFour test = new DayFour("test/puzzleInputD4.txt");

        ArrayList<Passphrase> list = new ArrayList<>();
        for (Passphrase p : test.input) {
            list.add(p);
            assertEquals(true, test.isValidPassphrase(p));
        }
    }

    @Test
    public void isValidPassphraseAndNotAnagram() {
        DayFour test = new DayFour("test/test2InputD4.txt");

        ArrayList<Passphrase> list = new ArrayList<>(test.input);
        assertEquals(3, list.size());
    }
}