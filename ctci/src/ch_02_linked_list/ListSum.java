package ch_02_linked_list;

public class ListSum {
    public static void main(String[] args) {

    }

    public Node solution(Node l1, Node l2) {
        Node result = new Node(-1);
        Node curr = result;
        int carry = 0;

        l1 = reverse(l1);
        l2 = reverse(l2);

        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + carry;
            curr.next = new Node(sum % 10);
            carry = sum / 10;

            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;

            curr = curr.next;
        }
        if (carry != 0) {
            curr.next = new Node(carry);
        }

        return result.next;
    }

    public Node reverse(Node node) {
        Node curr = node;
        Node prev = null;
        Node newNext = null;
        while(curr != null){
            newNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = newNext;
        }

        return prev;
    }
}
