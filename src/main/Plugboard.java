package main;

public class Plugboard {

    private String wires;

    public Plugboard(String wires) throws InvalidPlugboardWiresException {
        if (!validateWirePairs(wires)) throw new InvalidPlugboardWiresException();
        this.wires = wires;
    }

    public String process(String wire) {
        // if input does not match A-Z or is not plugged in this board
        if (!wire.matches("^[A-Z]+") || !wires.contains(wire)) return wire;

        // return paired character
        int index = wires.indexOf(wire);
        return String.valueOf(index % 2 == 0 ? wires.charAt(index + 1) : wires.charAt(index - 1));
    }

    private boolean validateWirePairs(String wires) {
        boolean isValid = true;

        // any pairs should be divisible by 2 and wires cannot exceed 10 pairs
        if (wires.length() % 2 != 0 || wires.length() > 20) isValid = false;

        // it's impossible to have more than 1 connection per alphabetic character
        for (String s : wires.split("")) {
            String singleWires = wires.replaceFirst(s, "");
            if (singleWires.contains(s)) isValid = false;
        }

        return isValid;
    }
}
