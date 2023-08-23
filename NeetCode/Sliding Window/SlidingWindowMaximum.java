import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {
    public static int[] windowMaximum(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n-k+1];
        Deque<Integer> window = new ArrayDeque<>();

        for(int i = 0;i < n;i++) {
            while(!window.isEmpty() && window.peekFirst() < i-k+1) {
                window.pollFirst();
            }

            while(!window.isEmpty() && nums[window.peekLast()] < nums[i]) {
                window.pollLast();
            }

            window.offerLast(i);

            if(i >= k-1) {
                result[i-k+1] = nums[window.peekFirst()];
            }
        }
        
        return result;
    }                                                                                   //! Total Time Complexity = O(n)
    
    public static void main(String[] args) {
        // int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        // int k = 3;

        int[] nums = {1, 1, 1, 1, 1, 4, 5};
        int k = 6; 
        
        System.out.println(Arrays.toString(windowMaximum(nums, k)));
    }
}
