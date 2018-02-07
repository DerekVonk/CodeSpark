package main;

import org.junit.Test;
import static org.junit.Assert.*;

public class PlugboardTest {
    @Test
    public void testValidPlugboard() throws InvalidPlugboardWiresException {
        Plugboard plugboard = new Plugboard("AB");
        assertEquals("B", plugboard.process("A"));
        assertEquals("A", plugboard.process("B"));
        assertEquals("C", plugboard.process("C"));
        assertEquals(".", plugboard.process("."));
    }


}