package ch_04_tree_graph.q05_bst_validator;

public class BSTValidator {

    Node root;

    public boolean validateBSTWrong(Node root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.val > root.val) {
            return false;
        }
        if (root.right != null && root.right.val < root.val) {
            return false;
        }
        return validateBST(root.left) && validateBST(root.right);
    }

    public boolean validateBST(Node root) {
        return validateBST(root, null, null);
    }

    public boolean validateBST(Node root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if ((min != null && root.val < min) || (max != null && root.val < max)) {
            return false;
        }

        if (!validateBST(root.left, min, root.val) || !validateBST(root.right, root.val, max)) {
            return false;
        }
        return false;
    }

    class Node {
        int val;
        Node left;
        Node right;

        public String toString() {
            return val + "";
        }
    }
}
