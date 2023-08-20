public class LinkedListCycle {
    public static class ListNode {
        int value;
        ListNode next;
        ListNode() {}
        ListNode(int x) {
            this.value = x;
            this.next = null;
        }
    } 
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {          //! Time Complexity = O(n)
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return true;
            }
        }
        return false;
    }                                                       //! Total Time Complexity = O(n)

    public static void main(String[] args) {
        int[] values = {1, 2, 3};
        ListNode head = new ListNode(values[0]);
        ListNode current = head;

        for(int i = 1;i < values.length;i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        // current.next = head.next;

        System.out.println(hasCycle(head));
    }
}
