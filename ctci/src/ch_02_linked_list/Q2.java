package ch_02_linked_list;

public class Q2 {
    public static void main(String[] args) {
        int size = 10;
        Node input = Node.createRandomLinkedList(size, 9);
        System.out.println(input.toString());
        System.out.println();

        Q2 q2 = new Q2();
        for (int i = 1; i <= size; i++) {
            System.out.printf("%dth: %d\n", i, q2.findKthElement(input, i));
        }
    }

    public int findKthElement(Node node, int step) {
        if (node == null && step > 0) {
            return -1;
        }
        Node right = node;
        for (int i = 0; i < step; i++) {
            if (node == null) {
                return -1;
            }
            right = right.next;
        }

        while (right != null) {
            right = right.next;
            node = node.next;
        }

        return node.val;
    }
}
