public class CopyRandomPointer {

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

    public static class Node {
        int value;
        Node next;
        Node random;

        public Node(int value) {
            this.value = value;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomNode(Node head) {
        
    }
    
    public static void main(String[] args) {
        
    }
}
