package main;

import utility.FileUtils;

import java.io.IOException;
import java.util.*;

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

        for (Program program : programs) {
            if (program.isHasDisk()) {
                result.put(program, getEdgePrograms(program, programs));
            }
        }

        return result;
    }

    private ArrayList<Edge> sortEdges() {
        ArrayList<Edge> sortedEdges = new ArrayList<>();
        for (List<Edge> connectedEdges : adj.values()) {
            sortedEdges.addAll(connectedEdges);
        }
        Collections.sort(sortedEdges);

        return sortedEdges;
    }

    private List<Program> initProgramList() {
        programs = new ArrayList<>();

        Program program = null;
        for (String line : fileContents) {
            program = getProgramFromLine(line);

            if (!programExists(programs, program)) {
                programs.add(program);
            }
//            System.out.println(program.toString());
        }

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

    private List<Edge> getEdgePrograms(Program firstProgram, List<Program> programs) {
        List<Edge> edges = new ArrayList<>();

        Edge e = null;
        String[] balancingPrograms = firstProgram.getBalancingPrograms();
        for (int i = 0; i < balancingPrograms.length; i++) {
            for (Program secondProgram : programs) {
                if (balancingPrograms[i].equalsIgnoreCase(secondProgram.getName())) {

                    e = new Edge(firstProgram, secondProgram, firstProgram.getWeight());
                    edges.add(e);
                    break;
                }
            }
        }
        return edges;
    }

    public String getBaseProgram() {

        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> supporting = new ArrayList<>();

        for (Program program : programs) {
            names.add(program.getName());
        }

        for (Program program : programs) {
            String[] balancingPrograms = program.getBalancingPrograms();
            for (String balancingProgram : balancingPrograms) {
                supporting.add(balancingProgram);
            }
        }

        for (String name : names) {
            if (!supporting.contains(name)) {
                return name;
            }
        }

        return null;
    }
}
