import java.util.HashMap;

public class containsDuplicate {

    public static boolean hashing(int[] testArray) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < testArray.length;i++) {
            if(map.containsKey(testArray[i])) {
                return true;
            }
            map.put(testArray[i], 1);
        }

        return false;
    }
    public static void main(String[] args) {
        int[] testArray = {1,2,3,1};

        System.out.println(hashing(testArray));
    }
}