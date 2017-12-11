package utility;

import main.Edge;

public class Node {

    Edge data;
    Node left, right;

    public Node(Edge d) {
        data = d;
        left = right = null;
    }
}
