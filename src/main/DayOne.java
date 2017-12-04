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

    public int calculateSecondSum() {
        int halfway = integers.length / 2;
        int realIndex = 0;

        for (int i = 0; i < integers.length; i++) {
                try {
                    if (integers[i] == integers[i + halfway]) {
                        sum += integers[i];
                    }
                } catch (IndexOutOfBoundsException e) {
                    realIndex = (i + halfway) - integers.length;

                    if (integers[i] == integers[realIndex]) {
                        sum += integers[i];
                    }
                }
            }
        return sum;
    }
}
