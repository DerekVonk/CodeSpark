package main.graphneighborhood;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GraphOperations {

    public static Set<Vertex> getNeighbours(Graph graph, Vertex vertex){
        return graph
                .getEdges()
                .stream()
                .filter(x -> x.getV1().equals(vertex) || x.getV2().equals(vertex))
                .map(x -> x.getV1().equals(vertex) ? x.getV2() : x.getV1())
                .collect(Collectors.toSet());
    }

    public static int hopDistance(Graph graph, Vertex source, Vertex target) {
        int hops = 1;

        Set<Vertex> friends = getNeighbours(graph, target);
        if (friends.contains(target)) {
            return hops;
        } else {
            hops++;
            Set<Vertex> fofs;
            for (Vertex friendOfFriend : friends) {
                fofs = getNeighbours(graph, friendOfFriend);
                if (fofs.contains(target)) {
                    return hops;
                } else {
                    hops++;
                }
            }

        }

        return hops;
    }
}
