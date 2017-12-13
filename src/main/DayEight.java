package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DayEight {

    final ArrayList<String[]> instructions;
    HashMap<String, Long[]> registers;

    public DayEight(String filename) {
        this.instructions = readArrayFromFile(filename);
        this.registers = new HashMap<>();
    }

    public void runInstructions() {
        for (String[] instruction : instructions) {
            processInstruction(instruction);
        }
    }
    
    private ArrayList<String[]> readArrayFromFile(String filename) {
        ArrayList<String[]> result = new ArrayList<>();
        try {
            File file = new File(filename);
            FileReader reader = new FileReader(file);
            BufferedReader bReader = new BufferedReader(reader);
            String line;
            while ((line = bReader.readLine()) != null) {
                String[] instructions = line.split(" ");
                result.add(instructions);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    private void processInstruction(String[] instructions) {
        // get register key
        String register = instructions[0];
        if (!registers.containsKey(register)) {
            registers.put(register, new Long[]{0L, 0L});
        }

        // get operation
        String operand;
        if (instructions[1].equalsIgnoreCase("inc")) {
            operand = "+";
        } else {
            operand = "-";
        }

        // get value to perform operation with
        long value = Long.valueOf(instructions[2]);

        // get register to use in condition check
        String comparedReg = instructions[4];
        if (!registers.containsKey(comparedReg)) {
            registers.put(comparedReg, new Long[]{0L, 0L});
        }

        // get the boolean operand
        String check = instructions[5];
        // get the value of the register to use in the condition check
        String valueComparedReg = instructions[6];

        boolean condition = false;
        switch(check) {
            case ">":
                condition = registers.get(comparedReg)[0] > Long.valueOf(valueComparedReg);
                break;
            case "<":
                condition = registers.get(comparedReg)[0] < Long.valueOf(valueComparedReg);
                break;
            case ">=":
                condition = registers.get(comparedReg)[0] >= Long.valueOf(valueComparedReg);
                break;
            case "<=":
                condition = registers.get(comparedReg)[0] <= Long.valueOf(valueComparedReg);
                break;
            case "==":
                condition = registers.get(comparedReg)[0].longValue() == Long.valueOf(valueComparedReg);
                break;
            case "!=":
                condition = registers.get(comparedReg)[0].longValue() != Long.valueOf(valueComparedReg);
                break;
        }

        Long[] newRegisterValues = registers.get(register).clone();
        Long registerValue = null;
        Long highestRegValue = null;
        if (condition) {
            if (operand.equalsIgnoreCase("+")) {

                registerValue = newRegisterValues[0];
                highestRegValue = newRegisterValues[1];

                if (highestRegValue > registerValue + value) {
                    newRegisterValues[0] = registerValue + value;
                } else {
                    newRegisterValues[0] = registerValue + value;
                    newRegisterValues[1] = newRegisterValues[0];
                }

                registers.replace(register, registers.get(register), newRegisterValues);
            } else if (operand.equalsIgnoreCase("-")) {

                registerValue = newRegisterValues[0];
                highestRegValue = newRegisterValues[1];

                if (highestRegValue > registerValue - value) {
                    newRegisterValues[0] = registerValue - value;
                } else {
                    newRegisterValues[0] = registerValue - value;
                    newRegisterValues[1] = newRegisterValues[0];
                }


                registers.replace(register, registers.get(register), newRegisterValues);
            } else {
                throw new UnsupportedOperationException("can't handle other operands yet...");
            }
        }
    }

    public Long[] getRegisterValue(String key) {
        return registers.get(key);
    }
    
    public Long getHighestRegisterValue() {
        HashMap.Entry<String, Long[]> maxEntry = null;

        for (Map.Entry<String, Long[]> entry : registers.entrySet()) {
            if (maxEntry == null || entry.getValue()[0].compareTo(maxEntry.getValue()[0]) >= 0) {
                maxEntry = entry;
            }
        }

        return maxEntry.getValue()[0];
    }

    public Long getHighestRegisterHeldValue() {
        HashMap.Entry<String, Long[]> maxEntry = null;

        for (Map.Entry<String, Long[]> entry : registers.entrySet()) {
            if (maxEntry == null || entry.getValue()[1].compareTo(maxEntry.getValue()[1]) >= 0) {
                maxEntry = entry;
            }
        }

        return maxEntry.getValue()[1];
    }


}
