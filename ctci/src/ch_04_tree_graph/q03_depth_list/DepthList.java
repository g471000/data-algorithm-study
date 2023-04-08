package ch_04_tree_graph.q03_depth_list;

import java.util.ArrayList;
import java.util.LinkedList;

public class DepthList {

    Node root;

    public void add(int val) {
        root = add(root, val);
    }

    public Node add(Node curr, int val) {
        if (curr == null) {
            curr = new Node(val);
        } else if (curr.val < val) {
            curr.right = add(curr.right, val);
        } else {
            curr.left = add(curr.left, val);
        }
        return curr;
    }

    public String toString() {
        return root.toString();
    }

//    public void createLinkedList() {
//        if (root != null) {
//            root = createLinkedList(root);
//        }
//    }

    public void createLinkedList(Node root, ArrayList<LinkedList<Node>> lists, int level) {
        if (root == null) {
            return;
        }

        LinkedList<Node> list = null;
        if (lists.size() == level) {
            list = new LinkedList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);
        createLinkedList(root.left, lists, level + 1);
        createLinkedList(root.right, lists, level + 1);
    }

    ArrayList<LinkedList<Node>> createLinkedList() {
        ArrayList<LinkedList<Node>> lists = new ArrayList<>();
        createLinkedList(root, lists, 0);
        return lists;
    }

    public String printLinkedList() {
        ArrayList<LinkedList<Node>> lists = createLinkedList();
        StringBuilder sb = new StringBuilder();
        for (LinkedList<Node> list : lists) {
           sb.append(list + "\n");
        }
        return sb.toString();
    }


    class Node {
        int val;
        Node left;
        Node right;
        Node next;

        Node(int val) {
            this.val = val;
        }

        public String toString() {
            String result = val + ", ";
            if (left != null) {
                result += left.toString();
            }
            if (right != null) {
                result += right.toString();
            }
            return result;
        }
    }
}