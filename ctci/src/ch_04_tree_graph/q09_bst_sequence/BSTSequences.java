package ch_04_tree_graph.q09_bst_sequence;

import java.util.ArrayList;
import java.util.LinkedList;

public class BSTSequences {
    public static ArrayList<LinkedList<Integer>> allSequences(Node node) {

        ArrayList<LinkedList<Integer>> results = new ArrayList<>();
        if (node == null) {
            results.add(new LinkedList<>());
            return results;
        }

        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(node.val);

        ArrayList<LinkedList<Integer>> left_seq = allSequences(node.left);
        ArrayList<LinkedList<Integer>> right_seq = allSequences(node.right);

        for (LinkedList<Integer> left : left_seq) {
            for (LinkedList<Integer> right : right_seq) {
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
                weave(left, right, weaved, prefix);
                results.addAll(weaved);
            }
        }

        return results;
    }

    public static void weave(LinkedList<Integer> left,
                                                LinkedList<Integer> right,
                                                ArrayList<LinkedList<Integer>> results,
                                                LinkedList<Integer> prefix){
        if (left.size() == 0 || right.size() == 0) {
            LinkedList result = (LinkedList) prefix.clone();
            result.addAll(left);
            result.addAll(right);
            results.add(result);
            return;
        }

        int headLeft = left.removeFirst();
        prefix.addLast(headLeft);
        weave(left, right, results, prefix);
        prefix.removeLast();
        left.addFirst(headLeft);

        int headRight = right.removeFirst();
        prefix.addLast(headRight);
        weave(left, right, results, prefix);
        prefix.removeLast();
        right.addFirst(headRight);
    }


}
