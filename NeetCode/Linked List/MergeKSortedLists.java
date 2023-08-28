public class MergeKSortedLists {

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

    public static ListNode sortLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        
        return mergeKListsHelper(lists, 0, lists.length-1);
    }

    private static ListNode mergeKListsHelper(ListNode[] lists, int start, int end) {
        if(start == end) return lists[start];

        if(start+1 == end) return sortTwoLists(lists[start], lists[end]);

        int mid = start + (end-start)/2;
        ListNode left = mergeKListsHelper(lists, start, mid);
        ListNode right = mergeKListsHelper(lists, mid+1, end);

        return sortTwoLists(left, right);
    }                                                                               //! Total Time Complexity = O(nlog K)

    private static ListNode sortTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while(l1 != null && l2 != null) {
            if(l1.value < l2.value) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }

            tail = tail.next;
        }

        if(l1 != null) tail = l1;
        if(l2 != null) tail = l2;

        return dummy.next;
    }                                                                               //! Time Complexity = O(n)

    public static void main(String[] args) {
        int[][] lists = {{1, 4, 5}, {1, 3, 4}, {2, 6}};
        ListNode[] nodeList = new ListNode[lists.length];
        int count = 0;

        for(int[] list: lists) {
            ListNode node = new ListNode(-1);
            ListNode current = node;
            for(int a: list) {
                current.next = new ListNode(a, null);
                current = current.next;
            }

            nodeList[count] = node.next;
            count++;
        }

        System.out.println(sortLists(nodeList));;
    }
}
