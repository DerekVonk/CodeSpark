package main;

public class Edge implements Comparable<Edge> {
    public Program first;
    public Program second;
    int weight;

    Edge(Program first, Program second, int weight) {
        this.first = first;
        this.second = second;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge e) {
        if (weight < e.weight) {
            return -1;
        } else if (weight > e.weight) {
            return 1;
        } else {
            return 0;
        }
    }
}
