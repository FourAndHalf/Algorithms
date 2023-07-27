import java.util.Arrays;

public class TwoSumII {

    //* Brute Force Method
    public static int[] sumCalculator(int[] nums, int target) {
        int first = 0;
        int second;
        
        while(first < nums.length-1) {                                          //! Time Complexity = O(n)
            second = first + 1;
            while(second < nums.length) {                                       //! Time Complexity = O(n)
                if((nums[first]+nums[second]) == target) {
                    return new int[] {first+1, second+1};
                }
                second++;
            }
            first++;
        }
        return new int[] {};
    }                                                                           //! Total Time Complexity = O(n^2)

    //* Optimized Method
    public static int[] optimizedSumCalculator(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {                                                   //! Time Complexity = O(n)
            if(nums[start] + nums[end] < target) {
                start++;
            } else if(nums[start] + nums[end] > target) {
                end--;
            } else {
                return new int[] {start+1, end+1};                
            }
        }
        return new int[] {};                                                    
    }                                                                           //! Total Time Complexity = O(n)

    public static void main(String[] args) {
        int[] nums = {5, 25, 75};
        int target = 100;

        System.out.println(Arrays.toString(optimizedSumCalculator(nums, target)));
    }
}