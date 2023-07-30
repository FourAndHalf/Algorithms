import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

public class CarFleet {
    public static int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> fleet = new Stack<>();
        HashMap<Integer, Integer> pair = new HashMap<>();

        for(int i = 0;i < position.length;i++) {                                    //! Time Complexity = O(n)
            pair.put(position[i], speed[i]);
        }

        ArrayList<Integer> sortedKeys = new ArrayList<>(pair.keySet());
        Collections.sort(sortedKeys);                                               //! Time Complexity = O(nlog n)
        Collections.reverse(sortedKeys);                                            //! Time Complexity = O(n)

        for(Integer keys : sortedKeys) {                                            //! Time Complexity = O(n)
            double time =(double) (target - keys)/pair.get(keys); 
            fleet.push(time);
            if(fleet.size() >= 2 && fleet.peek() <= fleet.get(fleet.size() - 2)) {
                fleet.pop();
            }
        }

        return fleet.size();
    }                                                                               //! Total Time Complexity = O(nlog n)

    public static void main(String[] args) {
        // int target = 12;
        // int[] position = {10, 8 , 0, 5, 3};
        // int[] speed = {2, 4, 1, 1, 3};
        
        int target = 10;
        int[] position = {6, 8};
        int[] speed = {3, 2};
        
        System.out.println(carFleet(target, position, speed));
    }
}