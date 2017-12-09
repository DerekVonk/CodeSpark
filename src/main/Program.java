package main;

public class Program {

    private String name;
    private int weight;
    private boolean hasDisk;

    public Program(String n, boolean d) {
        this(n, 0, d);
        System.out.println("Error in retrieving weight...");
    }

    public Program(String n, int w, boolean d) {
        this.name = n;
        this.weight = w;
        this.hasDisk = d;
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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(this.name)
                .append(" (")
                .append(this.weight)
                .append(") ");

        if (this.hasDisk) {
            builder.append(" -> ");
        }
        return builder.toString();
    }
}
