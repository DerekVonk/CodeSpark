package main;

import com.google.common.base.Preconditions;

//Guava against Million dollar error
public class Sum{

    private static final String I_A_MESSAGE = "Illegal Argument passed: ";

    public static Double sum(Double a, Double b) {
        Preconditions.checkNotNull(a, I_A_MESSAGE + "First parameter is Null.");
        Preconditions.checkNotNull(b, I_A_MESSAGE + "Second parameter is Null.");
        Preconditions.checkArgument(a > 0, I_A_MESSAGE + "Non-positive value %s", a);
        Preconditions.checkArgument(b > 0, I_A_MESSAGE + "Non-positive value %s", b);
        return a+b;
    }
}