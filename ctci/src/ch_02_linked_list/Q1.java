package ch_02_linked_list;

import java.util.HashSet;
import java.util.Set;

public class Q1 {

    public static void main(String[] args) {
        Node head = Node.createRandomLinkedList(101, 10);
        System.out.println(head.toString());

        Q1 q1 = new Q1();
//        Node removedDup = q1.removeDuplicate(head);
        Node removedDup = q1.removeDup(head);
        System.out.println("removed: " + removedDup.toString());

        System.out.println();
        Node head2 = Node.createRandomLinkedList(101, 10);
        System.out.println(head2.toString());

//        removedDup = q1.removeDuplicate(head2);
        removedDup = q1.removeDup(head2);
        System.out.println(removedDup.toString());
    }

    public Node removeDup(Node node){
        if(node == null){
            return null;
        }

        Set<Integer> set = new HashSet<>();
        set.add(node.val);

        Node curr = node;
        while(curr.next != null){
            if(set.contains(curr.next.val)){
                curr.next = curr.next.next;
            } else {
                set.add(curr.next.val);
                curr = curr.next;
            }
        }
        return node;
    }











    public Node removeDuplicate(Node node) {
        if (node == null) {
            return null;
        }
        HashSet<Integer> set = new HashSet<>();
        Node dummy = new Node(-1);
        dummy.next = node;
        Node curr = dummy;
        while (curr.next != null) {
            if (set.contains(curr.next.val)) {
                removeNext(curr);
            } else {
                set.add(curr.next.val);
                curr = curr.next;
            }
        }
        return node;
    }

    public Node removeDuplicate2(Node node) {
        Node left = node;
        Node right = node.next;
        while (left.next != null && left != null) {
            if (right == null) {
                left = left.next;
                if (left != null) {
                    right = left.next;
                }
            } else if (right.val == left.val) {
                remove(right);
                if (right != null) {
                    right = right.next;
                }
            } else {
                right = right.next;
            }
        }
        return node;
    }

    public void remove(Node node) {
        if (node != null) {
            if (node.next != null) {
                node.next = node.next.next;
            } else {
                node = null;
            }
        }
    }

    public void removeNext(Node node) {
        if (node.next != null) {
           node.next = node.next.next;
        }
    }
}
