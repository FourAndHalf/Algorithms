import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class topKFrequentElements {
    public static int[] frequencyFinder(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        Arrays.sort(nums);                                                      //! Time Complexity = O(nlog n)
    
        for (int i = 0; i < nums.length; i++) {                                 //! Time Complexity = O(n)
            if(map.containsKey(nums[i])) {
                int count = map.get(nums[i]) + 1;
                map.put(nums[i], count);
            } else {
                map.put(nums[i], 1);
            }
        }

        int[] array = new int[k];
        int j = 0;

        for (int i = 0; i < k; i++) {                                           //! Time Complexity = O(n)
            int freq = 0;
            int max = 0;
            for(Map.Entry<Integer, Integer> values: map.entrySet()) {           //! Time Complexity = O(n)
                if(values.getValue() > freq) {
                    freq = values.getValue();
                    max = values.getKey();
                }
            }
            map.put(max, 0);
            array[j] = max;
            j++;
        }

        return array;
    }                                                                           //! Time Complexity = O(n^2)
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        System.out.println(Arrays.toString(frequencyFinder(nums, k)));
    }
}