package ch_04_tree_graph.q09_bst_sequence;


import java.util.ArrayList;
import java.util.LinkedList;

public class Runner {
    public static void main(String[] args) {
        Node root = new Node(5);

        root.left = new Node(2);
        root.right = new Node(7);

        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.left.right.right = new Node(4);

        root.right.left = new Node(6);
        root.right.right = new Node(9);
        root.right.right.left = new Node(8);
        root.right.right.right = new Node(10);

        ArrayList<LinkedList<Integer>> results = BSTSequences.allSequences(root);
        for (int i = 0; i < results.size(); i++) {
            System.out.println(i + ": " + results.get(i));
        }
    }
}
