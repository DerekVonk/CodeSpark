package main;

import utility.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DaySeven extends FileUtils {

    List<String> fileContents;
    List<Program> programs;

    public DaySeven(String filename) throws IOException {
        this.fileContents = FileUtils.readFileAsListOfStrings(filename);
    }

    public List<Program> initProgramList() {
        programs = new ArrayList<>();

        Program program = null;
        for (String line : fileContents) {
            program = getProgramFromLine(line);
            programs.add(program);
        }

        return programs;
    }

    private Program getProgramFromLine(String line) {
        boolean hasDisk = false;

        String[] split = line.split(" ");

        String name = split[0];
        String[] split1 = split[1].split("(|)");

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < split1.length - 1; i++) {
            sb.append(split1[i]);
        }
        int weight = Integer.valueOf(sb.toString());

        if (split.length > 2) {
            hasDisk = true;

            // retrieve other program names

        }

        return new Program(name, weight, hasDisk);
    }

}
