public class ReverseKGroups {
    public static class ListNode {
        int value;
        ListNode next;

        public ListNode() {}
        public ListNode(int value) {
            this.value = value;
        }
        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }

    public static ListNode getKth(ListNode current, int k) {
        while(current != null && k != 0) {
            current = current.next;
            k--;
        }
        return current;
    }
    public static ListNode ReverseLinkedList(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode groupPrev = dummy;

        while(true) {
            ListNode Kth = getKth(groupPrev, k);
            if(Kth == null) {
                break;
            }
            ListNode groupNext = Kth.next;

            //? Reverse Group 
            ListNode prev = Kth.next;
            ListNode curr = groupPrev.next;
            ListNode temp;

            while(curr != groupNext) {
                temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            temp = groupPrev.next;
            groupPrev.next = Kth;
            groupPrev = temp;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 2;
        
        ListNode head = new ListNode(nums[0]);
        ListNode current = head;

        for(int i = 0;i < nums.length;i++) {
            current.next = new ListNode(nums[i]);
            current = current.next;
        }

        ReverseLinkedList(head, k);
    }
}