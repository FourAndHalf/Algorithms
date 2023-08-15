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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode pointer1 = list1;
        ListNode pointer2 = list2;
        ListNode mergedList;

        if(pointer1.value < pointer2.value) {
            mergedList = new ListNode(pointer1.value);
            pointer1 = pointer1.next;
        } else {
            mergedList = new ListNode(pointer2.value);
            pointer2 = pointer2.next;
        }

        ListNode current = mergedList;

        while(pointer1 != null || pointer2 != null) {
            if(pointer1.value < pointer2.value) {
                current.next = new ListNode(pointer1.value);
                pointer1 = pointer1.next;
            } else {
                current.next = new ListNode(pointer2.value);
                pointer2 = pointer2.next;
            }
        }
        return mergedList;
    }

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

    }
}
