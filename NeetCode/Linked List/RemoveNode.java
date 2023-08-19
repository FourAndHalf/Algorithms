public class RemoveNode {
  
  public static class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) {
      this.val = val;
    }
    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  } 

  public static ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0, head);
    ListNode lag = dummy;
    ListNode current = head;
    
    while(n != 0) {
      current = current.next;
      n--;
    }

    while(current != null) {
      lag = lag.next;
      current = current.next;
    }

    lag.next = lag.next.next;

    return dummy.next;
  }                                                                     //! Total Time Complexity = O(n)

  public static void main(String[] args) {
    int[] values = {1, 2, 3, 4, 5};
    int n = 2;

    ListNode head = new ListNode(values[0]);
    ListNode current = head;
    for(int i = 1;i < values.length;i++) {
      current.next =  new ListNode(values[i]);
      current = current.next;
    }

    removeNthFromEnd(head, n);
  }
}
