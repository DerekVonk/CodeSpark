package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Program {

    private int number;
    private String name;
    private int weight;
    private boolean hasDisk;
    private String[] balancingPrograms = new String[] {};

    public Program(String n, int w, boolean d, String[] bps) {
        this.number = 0;
        this.name = n;
        this.weight = w;
        this.hasDisk = d;
        if (hasDisk) {
            balancingPrograms = bps;
        }
    }

    // figure out when program has number higher number than 0!
    public Program(int number, String n, int w, boolean d, String[] bps) {
        this.number = number;
        this.name = n;
        this.weight = w;
        this.hasDisk = d;
        if (hasDisk) {
            balancingPrograms = bps;
        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isHasDisk() {
        return hasDisk;
    }

    public String[] getBalancingPrograms() {
        return balancingPrograms;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(this.name)
                .append(" (")
                .append(this.weight)
                .append(") ");

        if (this.hasDisk) {
            builder.append(" -> ");
            for (int i = 0; i < balancingPrograms.length; i++) {
                builder.append(balancingPrograms[i]);

                if (i != balancingPrograms.length -1) {
                    builder.append(", ");
                }
            }
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Program program = (Program) o;
        return getWeight() == program.getWeight() &&
                isHasDisk() == program.isHasDisk() &&
                Objects.equals(getName(), program.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getWeight(), isHasDisk());
    }

}
