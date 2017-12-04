package main;

public class DayOne {

    int[] integers;
    public int sum;

    public DayOne(String input) {
        this.processInput(input);
    }

    private void processInput(String input) {
        integers = new int[input.length()];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = Integer.parseInt(Character.toString(input.charAt(i)));
        }
    }

    public int calculateSum() {
        for (int i = 0; i < integers.length; i++) {

            if (i != integers.length - 1 && integers[i] == integers[i + 1]) {
                sum += integers[i];
            } else if (i == integers.length - 1 && integers[i] == integers[0]) {
                sum += integers[i];
            }
        }
        return sum;
    }
}
