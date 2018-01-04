package main;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Validate {

    public static boolean validate(String n) {
        char[] chars = n.toCharArray();
        int[] digits = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {
            digits[i] = Integer.parseInt(String.valueOf(chars[i]));
        }

        for (int i = digits.length - 2; i >= 0; i-=2) {
            digits[i] = digits[i] * 2;
            if (digits[i] > 9) digits[i] = digits[i] - 9;
        }

        int sum = Arrays.stream(digits).sum();

        return sum % 10 == 0;
    }
}

public class CreditCardValidationtest {
    @Test
    public void test() {
        assertEquals(false, Validate.validate("891"));
        assertEquals(true, Validate.validate("1230"));
    }
}
