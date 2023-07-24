import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class topKFrequentElements {

    //* Brute Force Method
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
    }                                                                           //! Total Time Complexity = O(n^2)

    //* Heap Method
    public int[] optimizedFrequencyFinder(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {                                                  //! Time Complexity = O(n)
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> counter.get(b) - counter.get(a));
        for (int num : counter.keySet()) {                                      //! Time Complexity = O(nlog k)
            heap.offer(num);
        }
        
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {                                           //! Time Complexity = O(k)
            result[i] = heap.poll();
        }
        
        return result;
    }                                                                           //! Total Time Complexity = O(nlog k)

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        System.out.println(Arrays.toString(frequencyFinder(nums, k)));
    }
}