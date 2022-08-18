package ch_02_linked_list;

public class Q3 {
    public static void main(String[] args) {
        int size = 10;
        Node input = Node.createRandomLinkedList(size, 9);
        System.out.println(input);
        System.out.println();

        Q3 q3 = new Q3();
        while (size > 0) {
            q3.removeCenter(input);
            System.out.println(input);
            size--;
        }
    }

    public void removeCenter(Node node) {
        if (node == null) {
            return;
        }

        Node prev = new Node(-1);
        prev.next = node;
        Node slow = node;
        Node fast = node;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        removeNext(prev);
    }

    public void remove(Node node) {
        if (node.next == null) {
            node = null;
        } else {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

    public void removeNext(Node node) {
        if (node == null) {
            return;
        } else if (node.next == null) {
            node.next = null;
        } else {
            node.next = node.next.next;
        }
    }
}
