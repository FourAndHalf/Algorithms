
/**
 * Permutations
 *
 * Given an array nums of unique integers, return all the possible permutations. 
 * You may return the answer in any order.
 *
 * Test Cases:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 *
 * Time Complexity: O(n! * n)   n: Size of Array
 * Space Complexity: O(n! * n)
 *
*/

public class Solution {
    List<List<int>> res = new List<List<int>>();

    public List<List<int>> Permute(int[] nums) {
        dfs(nums, new bool[nums.Length], new List<int>());

        return res;
    }

    private void dfs(int[] nums, bool[] pick, List<int> arr) {
        if (arr.Count == nums.Length) {
            res.Add(new List<int>(arr));
            return;
        }

        for (int i = 0;i < nums.Length;i++) {
            if (!pick[i]) {
                arr.Add(nums[i]);
                pick[i] = true;
                dfs(nums, pick, arr);
                arr.RemoveAt(arr.Count-1);
                pick[i] = false;
            }
        }
    }
}

