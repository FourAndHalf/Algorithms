import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class threeSum {
    public static List<List<Integer>> calculateThreeSum(int[] nums) {
        int target = 0;
        Arrays.sort(nums);                                                      //! Time Complexity = O(nlog n)

        Set<List<Integer>> s = new HashSet<>(); 
        List<List<Integer>> output = new ArrayList<>();

        for(int i = 0;i < nums.length;i++) {                                    //! Time Complexity = O(n)
            int j = i+1;
            int k = nums.length-1;

            while(j < k) {                                                      //! Time Complexity = O(n)
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target) {
                    s.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if(sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        output.addAll(s);
        
        return output;
    }                                                                           //! Total Time Complexity = O(n^2)

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        
        System.out.println(calculateThreeSum(nums));
    }
}