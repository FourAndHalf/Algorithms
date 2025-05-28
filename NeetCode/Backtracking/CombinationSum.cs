
/**
 * Combination Sum
 *
 *
 * You are given an array of distinct integers nums and a target integer target.
 * Your task is to return a list of all unique combinations of nums where the chosen numbers sum to target.
 * The same number may be chosen from nums an unlimited number of times.
 * Two combinations are the same if the frequency of each of the chosen numbers is the same, otherwise they are different.
 * You may return the combinations in any order and the order of the numbers in each combination can be in any order.
 *
 *
 * Test Case:
 *
 * Input: 
 * nums = [2,5,6,9] 
 * target = 9
 *
 * Output: [[2,2,5],[9]]
 *
 * 
 * Time Complexity: O(2^t/m) t: Target, m: Minimum value in nums
 * Space Complexity: O(t/m)
 *
*/

public class Solution {
    List<List<int>> res = new List<List<int>>();

    public List<List<int>> CombinationSum(int[] nums, int target) {
        backtrack(nums, target, 0, new List<int>(), 0);

        return res;
    }

    private void backtrack(int[] nums, int target, int sum, List<int> track, int i) {
        if (sum == target) {
            res.Add(track.ToList());        
            return;
        }
            
        if ((sum > target) || (i >= nums.Length))
            return;

        track.Add(nums[i]);
        backtrack (nums, target, sum + nums[i], track, i);

        track.Remove(nums[i]);
        backtrack(nums, target, sum, track, i+1);
    }
}

