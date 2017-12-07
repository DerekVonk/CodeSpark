package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DayFive {

    final int[] instructions;
    public static int offset = 0;
    private static int totalNumberOfJumps = 0;
    private int currentIndex = 0;



    public DayFive(String filename) {
        this.instructions = readArrayFromFile(filename);
    }

    public int countJumps() {
        try {

            for (int i = 0; i < instructions.length; i++) {

                int index = goToIndex(offset);

                instructions[i] = offset;

            }

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Escaped the maze in " + totalNumberOfJumps + " steps");
            return totalNumberOfJumps;
        }
        return 0;
    }

    private int goToIndex(int index) {
        System.out.println("current index is " + instructions[index]);

        totalNumberOfJumps++;

        return instructions[index];

    }

    private int[] readArrayFromFile(String filename) {
        int[] result = null;
        try {
            File file = new File(filename);
            FileReader reader = new FileReader(file);
            BufferedReader bReader = new BufferedReader(reader);
            StringBuffer stringBuffer = new StringBuffer();
            String line;

            ArrayList<Integer> list = new ArrayList<>();
            while ((line = bReader.readLine()) != null) {
                list.add(Integer.valueOf(line.toString()));
            }
            result = list.stream().mapToInt(i -> i).toArray();
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
