package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DayFive {

    final int[] instructions;
    private int totalNumberOfJumps = 0;



    public DayFive(String filename) {
        this.instructions = readArrayFromFile(filename);
    }

    public int countJumps() {
        int index = 0;

        while (index >= 0 && index < instructions.length) {
            int move = instructions[index];

            // remove if statement for part one of day five answer
            if (move >= 3) {
                instructions[index] = instructions[index] - 1;
            } else {
                instructions[index] = instructions[index] + 1;
            }

            totalNumberOfJumps++;
            index = index + move;
        }

        return totalNumberOfJumps;
    }

    private void goToIndex(int index) {
        System.out.println("current instruction -> move to index " + instructions[index]);

        goToIndex(0);
    }


    private int getInstruction(int index) {
        System.out.println("getting instruction for index: " + index);

        int temp = instructions[index];

        leaveInstruction(instructions[index], index);

        totalNumberOfJumps++;
        return instructions[temp];
    }

    private void leaveInstruction(int instruction, int index) {
        instructions[index] = instruction + 1;
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
