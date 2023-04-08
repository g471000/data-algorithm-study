package ch_04_tree_graph.q03_depth_list;

public class DepthList {

    Node root;

    public void add(int val){
        root = add(root, val);
    }

    public Node add(Node curr, int val) {
        if(curr == null) {
            curr = new Node(val);
        }
        else if (curr.val < val) {
            curr.right = add(curr.right, val);
        } else {
            curr.left = add(curr.left, val);
        }
        return curr;
    }

    public String toString() {
        return root.toString();
    }

    public void createLinkedList() {
        if (root != null) {
            root = createLinkedList(root);
        }
    }

    public Node createLinkedList(Node curr) {
        if (curr.left == null && curr.right == null) {
            return null;
        } else if (curr.left == null) {

        }
        return null;
    }

    public Node getNext(Node curr) {
        if (curr.next == null) {
            return null;
        }

        return null;
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