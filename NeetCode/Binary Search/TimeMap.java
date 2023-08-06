import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TimeMap {
    HashMap<String, List<Node>> store = new HashMap<>(); 
    
    class Node {
        int time;
        String value;
        Node(String value, int time) {
            this.time = time;
            this.value = value;
        }
    }   

    public TimeMap() {
        store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        Node newNode = new Node(value, timestamp);
        if(store.containsKey(key)) {
            store.get(key).add(newNode);
        } else {
            List<Node> list = new ArrayList<>();
            list.add(newNode);
            store.put(key, list);
        }
    }                                                                               //! Time Complexity = O(1)

    public String get(String key, int timestamp) {
        String value = "";

        if(!store.containsKey(key)) return value;
        
        List<Node> list = store.get(key);
        int left = 0;
        int right = list.size() - 1;

        while(left <= right) {
            int middle = left + (right-left)/2;

            if(list.get(middle).time <= timestamp) {
                left = middle + 1;
                value = list.get(middle).value;
            } else {
                right = middle - 1;
            }
        }

        return value;
    }                                                                       //! Total Time Complexity = O(log n)

    public static void main(String[] args) {
        TimeMap obj = new TimeMap();
        obj.set("foo", "bar", 1);
        System.out.println(obj.get("foo", 1));
        System.out.println(obj.get("foo", 3));
        obj.set("foo", "bar2", 4);
        System.out.println(obj.get("foo", 4));
        System.out.println(obj.get("foo", 5));
    }
}
