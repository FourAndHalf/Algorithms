public class AddTwoNumbers {
    
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

    public static ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        int carry = 0;
        while(list1 != null || list2 != null || carry != 0) {                   //! Time Complexity = O(n)
            int v1 = (list1 != null) ? list1.value : 0; 
            int v2 = (list2 != null) ? list2.value : 0;

            int sum = v1 + v2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            current.next = new ListNode(sum);

            current = current.next;
            list1 = (list1 != null) ? list1.next : null;
            list2 = (list2 != null) ? list2.next : null;
        }

        return dummy.next;
    }                                                                           //! Total Time Complexity = O(n)

    public static void main(String[] args) {
        int[] values = {9};
        ListNode list1 = new ListNode(values[0]);
        ListNode current = list1;

        for(int i = 1;i < values.length;i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        int[] value = {1, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        ListNode list2 = new ListNode(value[0]);
        current = list2;

        for(int i = 1;i < value.length;i++) {
            current.next = new ListNode(value[i]);
            current = current.next;
        }

        addTwoNumbers(list1, list2);
    }
}
