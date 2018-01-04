package main;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

class BlackOrWhiteKey {

    public static String blackOrWhiteKey(int keyPressCount) {

        final String[] keys = new String[] {
                "white","black",
                "white","white",
                "black","white",
                "black","white",
                "white","black",
                "white","black",
        };

        while (keyPressCount > 88) { // code block is the same as keypresscount % 88.
            keyPressCount -= 88;
        }

        int index = keyPressCount % 12;

//       String test = keys[(keyPressCount-1) % 88 % 12]; ==> is better solution

        return index == 0 ? keys[++index] : keys[--index];
    }
}

public class BlackOrWhiteKeyTest {
    @Test
    public void ExampleTests() {
        assertEquals("white", BlackOrWhiteKey.blackOrWhiteKey(1));
        assertEquals("black", BlackOrWhiteKey.blackOrWhiteKey(5));
        assertEquals("black", BlackOrWhiteKey.blackOrWhiteKey(12));
        assertEquals("white", BlackOrWhiteKey.blackOrWhiteKey(42));
        assertEquals("white", BlackOrWhiteKey.blackOrWhiteKey(88));
        assertEquals("white", BlackOrWhiteKey.blackOrWhiteKey(89));
        assertEquals("white", BlackOrWhiteKey.blackOrWhiteKey(92));
        assertEquals("black", BlackOrWhiteKey.blackOrWhiteKey(100));
        assertEquals("white", BlackOrWhiteKey.blackOrWhiteKey(111));
        assertEquals("black", BlackOrWhiteKey.blackOrWhiteKey(200));
        assertEquals("white", BlackOrWhiteKey.blackOrWhiteKey(2017));
    }

}
