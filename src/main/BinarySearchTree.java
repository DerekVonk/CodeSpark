package main;

import java.util.Scanner;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class BinarySearchTree {

    /**
     * Prints the BNS to Standard out
     *
     * @param root Root node
     */
    public static void preOrder( Node root ) {
        if( root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

    /**
     * Inserts a new node
     *
     * @param current current node to insert at
     * @param data value to add to node
     * @return
     */
    public static Node insert(Node current, int data) {
        if (current == null) {
            return new Node(data);
        }

        if (data < current.data) {
            current.left = insert(current.left, data);
        } else if (data > current.data) {
            current.right = insert(current.right, data);
        }

        return current;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        preOrder(root);
    }
}