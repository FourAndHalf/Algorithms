public class MergeSortedLists {
    
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

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while(list1 != null && list2 != null) {                     //! Time Complexity = O(n)
            if(list1.value < list2.value) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }

            tail = tail.next;
        }

        if(list1 != null) {
            tail.next = list1;
        } else if(list2 != null) {
            tail.next = list2;
        }

        return dummy.next;
    }                                                               //! Total Time Complexity = O(n)

    public static void main(String[] args) {
        int[] values = {1, 2, 4};
        ListNode list1 = new ListNode(values[0]);
        ListNode current = list1;

        for(int i = 1;i < values.length;i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        int[] values2 = {1, 3, 4};
        ListNode list2 = new ListNode(values2[0]);
        current = list2;

        for(int i = 1;i < values2.length;i++) {
            current.next = new ListNode(values2[i]);
            current = current.next;
        }

        mergeTwoLists(list1, list2);
    }
}
