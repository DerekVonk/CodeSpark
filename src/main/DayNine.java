package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class DayNine {

    ArrayList<String> groups;
    String[] garbage;

    public DayNine(String filename) {
        this.groups = readArrayFromFile(filename);
//        this.garbage = new HashMap<>();
    }

    private ArrayList<String> readArrayFromFile(String filename) {
        ArrayList<String> result = new ArrayList<>();
        try {
            File file = new File(filename);
            FileReader reader = new FileReader(file);
            BufferedReader bReader = new BufferedReader(reader);
            String line;
            while ((line = bReader.readLine()) != null) {
                int groupCount = 0;
                int garbageCount = 0;

                String[] split = line.split(",");

                result.addAll(Arrays.asList(split));

            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int countOccurrences(String haystack, char needle)
    {
        int count = 0;
        for (int i=0; i < haystack.length(); i++)
        {
            if (haystack.charAt(i) == needle)
            {
                count++;
            }
        }
        return count;
    }

}
