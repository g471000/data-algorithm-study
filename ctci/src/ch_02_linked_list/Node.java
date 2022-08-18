package ch_02_linked_list;

import java.util.Random;

public class Node {
    int val;
    Node next;

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    public Node(int val) {
        this.val = val;
    }

    public String toString() {
        Node curr = this;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (curr != null) {
            sb.append(curr.val + "->");
            curr = curr.next;
        }
        sb.append("null]");
        return sb.toString();
    }

    public static Node createRandomLinkedList(int size, int maxVal) {
        Node dummy = new Node(-1);
        Node curr = dummy;
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            curr.next = new Node(random.nextInt(maxVal + 1));
            curr = curr.next;
        }
        return dummy.next;
    }
}
