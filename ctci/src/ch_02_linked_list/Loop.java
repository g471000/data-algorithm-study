package ch_02_linked_list;

public class Loop {
    public Node findLoop(Node node) {
        Node fast = node;
        Node slow = node;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = node;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
