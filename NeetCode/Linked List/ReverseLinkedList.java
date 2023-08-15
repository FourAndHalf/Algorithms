public class ReverseLinkedList {
    public static class ListNode {
        int value;
        ListNode next;
        ListNode() {}
        ListNode(int value) {
            this.value = value;
        }
        ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }   
    
    //* Iterative Method
    public static ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        ListNode temp;

        while(current != null) {                                //! Time Complexity = O(n)
            temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        
        return previous;
    }                                                           //! Total Time Complexity = O(n)

    //* Recursive Method
    public static ListNode recursiveReverseList(ListNode head) {
        if(head == null) return null;

        ListNode newHead = head;
        if(head.next != null) {                                 
            newHead = recursiveReverseList(head.next);
            head.next.next = head;
        }
        head.next = null;

        return newHead;
    }                                                           //! Total Time Complexity = O(n)

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(values[0]);
        ListNode current = head;

        for(int i = 1;i < values.length;i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        reverseList(head);
    }
}
