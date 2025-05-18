/*
 * Backtracking 
 * Given an array nums of unique integers, return all possible subsets of nums.
 * The solution set must not contain duplicate subsets. 
 * You may return the solution in any order.
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * Time Complexity: O(n * 2^n)
 * Space Complexity: O(n) - Extra space, O(2^n) - Output list
 *
*/
public class Solution {
    public List<List<int>> Subsets(int[] nums) {
        var res = new List<List<int>>();
        var subset = new List<int>();
        Dfs(nums, 0, subset, res);
        return res;   
    }

    private void Dfs(int[] nums, int i, List<int> subset, List<List<int>> res) {
        if (i >= nums.Length) {
            res.Add(new List<int>(subset));
            return;
        }

        subset.Add(nums[i]);
        Dfs(nums, i+1, subset, res);
        subset.RemoveAt(subset.Count-1);
        Dfs(nums, i+1, subset, res);
    }
}
