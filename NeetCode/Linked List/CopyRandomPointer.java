import java.util.HashMap;
import java.util.Map;

public class CopyRandomPointer {
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
    
    private static Map<Node, Node> map = new HashMap<>();

    public static Node copyRandomList(Node head) {
        if (head == null)
        return null;
        if (map.containsKey(head))
        return map.get(head);

        Node newNode = new Node(head.value);
        map.put(head, newNode);
        newNode.next = copyRandomList(head.next);
        newNode.random = copyRandomList(head.random);
        
        return newNode;
    }

    
    public static void main(String[] args) {
        int[] values = {7, 13, 11, 10, 1};
        Node head = new Node(values[0]);     
        Node current = head;

        for(int i = 1;i < values.length;i++) {
            current.next = new Node(i);
            current = current.next;
        }

        copyRandomList(head);
    }
}
