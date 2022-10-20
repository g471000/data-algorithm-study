package ch_02_linked_list;

public class Palindrome {

   public boolean isPalindrome(Node node) {
      Node reversed = reverseAndClone(node);
      return isEqual(reversed, node);
   }

   public boolean isEqual(Node n1, Node n2) {
      while (n1 != null && n2 != null) {
         if (n1.val != n2.val) {
            return false;
         }
         n1 = n1.next;
         n2 = n2.next;
      }

      return n1 == null && n2 == null;
   }

   // 1 - 2 - 3 - 4 - 5
   // -1
   // c
   public Node reverseAndClone(Node node) {
      Node head = null;
      while (node != null) {
         Node newNode = new Node(node.val);
         newNode.next = head;
         head = newNode;
         node = node.next;
      }
      return head;
   }
}
