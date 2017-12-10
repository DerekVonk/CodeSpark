package main;

import utility.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class DaySeven extends FileUtils {

    private List<String> fileContents;
    private List<Program> programs;
    private HashMap<Program, List<Edge>> adj;

    public DaySeven(String filename) throws IOException {
        this.fileContents = FileUtils.readFileAsListOfStrings(filename);
        this.programs = initProgramList();
        this.adj = initHashMap();
    }

    private HashMap<Program, List<Edge>> initHashMap() {
        HashMap<Program, List<Edge>> result = new HashMap();

        // insert into hashmap a key-value pair of each Program that has connected programs and with
        // a particular weight.

        for (Program program : programs) {
            if (program.isHasDisk()) {

                result.put(program, program.getBalancingPrograms(programs));

            }
        }

        return result;
    }

    private List<Program> initProgramList() {
        programs = new ArrayList<>();

        Program program = null;
        for (String line : fileContents) {
            program = getProgramFromLine(line);

            if (!programExists(programs, program)) {
                programs.add(program);
            }
            System.out.println(program.toString());
        }

        ArrayList<Edge> sortedEdges = new ArrayList<>();
        for (List<Edge> connectedEdges : adj.values()) {
            sortedEdges.addAll(connectedEdges);
        }
        Collections.sort(sortedEdges);

        return programs;
    }

    private Program getProgramFromLine(String line) {
        // split line into separate strings by removing non-word characters or non-number characters
        String[] split = line.split("\\s*[^a-z|0-9]+\\s*");

        String name = split[0];
        int weight = Integer.parseInt(split[1]);
        boolean hasDisk = false;
        String[] balancingPrograms = null;

        if (split.length > 2) {
            hasDisk = true;

            balancingPrograms = new String[split.length - 2];

            // retrieve other program names
            for (int i = 2, j = 0; i < split.length; i++, j++) {
                balancingPrograms[j] = split[i];
            }
        }

        return new Program(name, weight, hasDisk, balancingPrograms);
    }

    private boolean programExists(List<Program> programs, Program p) {
        for (Program program : programs) {
            if (program.equals(p)) {
                return true;
            }
        }
        return false;
    }

}
