import java.util.HashMap;

public class LRUCache {
    
    class ListNode {
        int key;
        int value;
        ListNode next;
        ListNode previous;
    
        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.previous = null;
            this.next = null;
        } 
    }

    ListNode head = new ListNode(-1, -1);
    ListNode tail = new ListNode(-1, -1);
    int cap;
    HashMap <Integer, ListNode> map = new HashMap<>();

    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.previous = head;    
    }
    
    private void addNode(ListNode newNode) {
        ListNode temp = head.next;

        newNode.next = temp;
        newNode.previous = head;
        
        head.next = newNode;
        temp.previous = newNode;
    }
    private void deleteNode(ListNode oldNode) {
        ListNode next = oldNode.next;
        ListNode previous = oldNode.previous;

        next.previous = previous;
        previous.next = next;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            ListNode node = map.get(key);
            int ans = node.value;

            map.remove(key);
            deleteNode(node);
            addNode(node);  

            map.put(key, head.next);

            return ans;
        }

        return -1;
    }
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            ListNode node = map.get(key);
            map.remove(key);
            deleteNode(node);
        }

        if(map.size() == cap) {
            map.remove(tail.previous.key);
            deleteNode(tail.previous);
        }

        addNode(new ListNode(key, value));
        map.put(key, head.next);
    }

}
