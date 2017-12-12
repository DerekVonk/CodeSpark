package main;

import java.util.ArrayList;
import java.util.Objects;

public class Program {

    private String name;
    private int weight;
    private boolean hasDisk;
    private ArrayList<String> balancingPrograms;

    public Program(String n, int w, boolean d, ArrayList<String> bps) {
        this.name = n;
        this.weight = w;
        this.hasDisk = d;
        if (hasDisk) {
            balancingPrograms = bps;
        }
    }

    public Program(String n, int w, boolean d) {
        this(n, w, d, new ArrayList<>());
    }

    public Program(String n) {
        this(n, 0, false,null);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setHasDisk(boolean hasDisk) {
        this.hasDisk = hasDisk;
    }

    public void setBalancingPrograms(ArrayList<String> balancingPrograms) {
        this.balancingPrograms = balancingPrograms;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public boolean hasDisk() {
        return hasDisk;
    }

    public ArrayList<String> getBalancingPrograms() {
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
            for (int i = 0; i < balancingPrograms.size(); i++) {
                builder.append(balancingPrograms.get(i));

                if (i != balancingPrograms.size() -1) {
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
        return
                Objects.equals(getName(), program.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getWeight(), hasDisk());
    }
}
