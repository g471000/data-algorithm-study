package ch_02_linked_list;

public class Union {
    public Node findUnion(Node n1, Node n2) {
        Node head1 = n1;
        Node head2 = n2;
        while (n1 != null || n2 != null) {
            if (n1 == n2) {
                return n1;
            }
            n1 = n1 == null ? head2 : n1.next;
            n2 = n2 == null ? head1 : n2.next;
        }
        return null;
    }
}
