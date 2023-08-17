public class ReorderList {

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

    public static void reorderList(ListNode list) {
        ListNode slow = list;
        ListNode fast = list.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }                                                       //! Time Complexity = O(n/2)

        ListNode second = slow.next;
        slow.next = null;
        ListNode prev = null;

        while(second != null) {
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }                                                       //! Time Complexity = O(n/2)

        second = prev;
        ListNode first = list;

        while(second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }                                                       //! Time Complexity = O(n)
    }                                                           //! Total Time Complexity = O(n)

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};
        ListNode list = new ListNode(values[0]);
        ListNode current = list;

        for(int i = 1;i < values.length;i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        reorderList(list);
    }
}
