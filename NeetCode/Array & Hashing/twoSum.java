import java.util.Arrays;

public class twoSum {
    public static int[] calculator(int[] nums, int target) {
        int n = nums.length;
        for(int i = 0;i < n-1;i++) {                                        //! Time Complexity = O(n)
            for(int j = i+1;j < n;j++) {
                if((nums[i] + nums[j]) == target) {                         //! Time Complexity = O(n)
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{}; 
    }                                                                       //! Total Time Complexity = O(n^2)
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;

        System.out.println(Arrays.toString(calculator(nums, target)));
    }
}