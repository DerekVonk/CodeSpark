package main.graphneighborhood;

import java.util.HashSet;
import java.util.Set;

public class GraphOperations {

    public static Set<Vertex> getNeighbours(Graph graph, Vertex vertex){
        Set<Vertex> result = new HashSet<>();
        Set<Edge> edges = graph.getEdges();
        int vertexUid = vertex.hashCode();

        for (Edge e : edges) {
            Vertex v1 = e.getV1();
            Vertex v2 = e.getV2();

            if (v1.hashCode() == vertexUid) {
                result.add(v2);
            } else if (v2.hashCode() == vertexUid) {
                result.add(v1);
            }
        }

        return result;
    }
}
