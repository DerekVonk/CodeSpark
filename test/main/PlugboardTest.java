package main;

import org.junit.Test;
import static org.junit.Assert.*;

public class PlugboardTest {
    @Test
    public void testValidPlugboard() throws InvalidPlugboardWiresException {
        Plugboard plugboard = new Plugboard("AB");
        assertEquals("B", plugboard.process("A"));
        assertEquals(".", plugboard.process("."));
        assertEquals("A", plugboard.process("B"));
        assertEquals("C", plugboard.process("C"));
    }

    @Test(expected = InvalidPlugboardWiresException.class)
    public void testInvalidPlugboard1() throws InvalidPlugboardWiresException {
        Plugboard plugboard = new Plugboard("ABC");
    }

    @Test(expected = InvalidPlugboardWiresException.class)
    public void testInvalidPlugboard2() throws InvalidPlugboardWiresException {
        Plugboard plugboard = new Plugboard("ABAD");
    }

    @Test(expected = InvalidPlugboardWiresException.class)
    public void testInvalidPlugboard3() throws InvalidPlugboardWiresException {
        Plugboard plugboard = new Plugboard("ABCDEFGHIJKLMNOPQRSTUV");
    }

}