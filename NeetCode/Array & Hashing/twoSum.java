import java.util.Arrays;
import java.util.HashMap;

public class twoSum {
    public static int[] twoSumCalculator(int[] nums, int target) {
        int n = nums.length;
        for(int i = 0;i < n-1;i++) {                                            //! Time Complexity = O(n)
            for(int j = i+1;j < n;j++) {
                if((nums[i] + nums[j]) == target) {                             //! Time Complexity = O(n)
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{}; 
    }                                                                           //! Total Time Complexity = O(n^2)

    public static int[] optimizedTwoSumCalculator(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for(int i = 0;i < n;i++) {                                              //! Time Complexity = O(n)
            map.put(nums[i], i);
        }

        for(int i = 0;i < n;i++) {                                              //! Time Complexity = O(n)
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i) {
                return new int[] {i, map.get(complement)};
            }
        }
        return new int[]{};
    }                                                                           //! Total Time Complexity = O(n)

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;

        System.out.println(Arrays.toString(optimizedTwoSumCalculator(nums, target)));
    }
}