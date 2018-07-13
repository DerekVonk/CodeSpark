package main.graphneighborhood;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GraphOperations {

    public static Set<Vertex> getNeighbours(Graph graph, Vertex vertex){
//        Set<Vertex> result = new HashSet<>();
//        Set<Edge> edges = graph.getEdges();
//        int vertexUid = vertex.hashCode();
//
//        for (Edge e : edges) {
//            Vertex v1 = e.getV1();
//            Vertex v2 = e.getV2();
//
//            if (v1.hashCode() == vertexUid) {
//                result.add(v2);
//            } else if (v2.hashCode() == vertexUid) {
//                result.add(v1);
//            }
//        }
//
//        return result;

        return graph
                .getEdges()
                .stream()
                .filter(x -> x.getV1().equals(vertex) || x.getV2().equals(vertex))
                .map(x -> x.getV1().equals(vertex) ? x.getV2() : x.getV1())
                .collect(Collectors.toSet());
    }

    public static int hopDistance(Graph graph, Vertex source, Vertex target) {
        return 1;
    }
}
