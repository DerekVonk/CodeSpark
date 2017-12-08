package main;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class DayTwo {

    private int[][] spreadsheet;
    private int size = -1;
    private int log10 = 0;
    private String numberFormat;
    private int sum = 0;

    public DayTwo(String filename) {
        try {
            readFile(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFile(String filename) throws IOException {
        BufferedReader buffer = new BufferedReader(new FileReader(filename));

        String line;
        int row = 0;

        while ((line = buffer.readLine()) != null) {
            String[] vals = line.trim().split("\\s+");

            // Lazy instantiation.
            if (spreadsheet == null) {
                size = vals.length;
                spreadsheet = new int[size][size];
                log10 = (int) Math.floor(Math.log10(size * size)) + 1;
                numberFormat = String.format("%%%dd", log10);
            }

            for (int col = 0; col < size; col++) {
                spreadsheet[row][col] = Integer.parseInt(vals[col]);
            }
            row++;
        }
    }
    
    @Override
    public String toString() {
        StringBuffer buff = new StringBuffer();

        if (spreadsheet != null) {
            for (int row = 0; row < size; row++) {
                buff.append(" ");
                for (int col = 0; col < size; col++) {
                    buff.append(String.format(numberFormat,  spreadsheet[row][col]));
                    if (col < size - 1) {
                        buff.append(" | ");
                    }
                }
                if (row < size - 1) {
                    buff.append("\n");
                    for (int col = 0; col < size; col++) {
                        for (int i = 0; i <= log10 + 1; i++) {
                            buff.append("-");
                        }
                        if (col < size - 1) {
                            buff.append("+");
                        }
                    }
                    buff.append("\n");
                } else {
                    buff.append("\n");
                }
            }
        }

        return buff.toString();
    }
    

    public int calculateFirstChecksum() {
        int smallest = 0;
        int largest = 0;

        // sort the array in order
        for (int i = 0; i < spreadsheet.length; i++) {
            for (int j = 0; j < spreadsheet[i].length; j++) {
                Arrays.sort(spreadsheet[j]);

                // retrieve smallest and largest numbers
                largest = spreadsheet[i][ spreadsheet[j].length - 1 ];
                smallest = spreadsheet[i][0];
            }

            // add to sum
            sum += largest - smallest;
            System.out.println("Row's largest and smallest values are " + largest + " and " + smallest
                    + " and their difference is " + (largest - smallest));
            System.out.println("New checksum is: " + (sum));
        }

        return sum;
    }

    public int calculateSecondChecksum() {
        sortArrayInDescendingOrder();

        for (int i = 0; i < spreadsheet.length; i++) {
            // You need to iterate within each subarray.
            int[] inner = spreadsheet[i];
            for (int k = 0; k < inner.length; k++) {
                int current = inner[k];

                // copy the remaining items in the array to a new array for iterating
                int[] subInner = Arrays.copyOfRange(inner, k + 1, inner.length);

                for (int n = 0; n < subInner.length; n++) {
                    int comparedTo = subInner[n]; // current value that "current" is comparing itself to
//                    System.out.println("array " + (i + 1) + " compare " + current + " to " + comparedTo);

                    try {
                        // add only the result of the division of two integers that evenly divide to sum
                        if (current % comparedTo == 0) {
                            System.out.println(" -- hit --");
                            System.out.println("array " + (i + 1) + " compare " + current + " to " + comparedTo);
                            sum += current / comparedTo;
                        }
                    } catch (ArithmeticException e) {
                        System.out.println("Can't divide by Zero... skipping");
                        continue;
                    }
                }
            }
        }

        return sum;
    }

    private void sortArrayInDescendingOrder() {
        for (int i = 0; i < spreadsheet.length; i++) {
            // sort inner array in descending order
            for (int j = 0; j < spreadsheet[i].length; j++) {
                Arrays.sort(spreadsheet[j]);
            }
        }

        for (int i = 0; i < spreadsheet.length; i++) {
            spreadsheet[i] = IntStream.of(spreadsheet[i])
                    .boxed()
                    .sorted(Comparator.reverseOrder())
                    .mapToInt(a -> a)
                    .toArray();
            }
        }
    }



