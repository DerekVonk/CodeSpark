package main;

public class Main {

    public static void main(String[] args) {

        DayOne dayOne = new DayOne(args[0]);

        int i = dayOne.calculateSum();

        System.out.println(i);

    }
}
