
/**
 * Combination Sum II
 *
 * You are given an array of integers candidates, which may contain duplicates, and a target integer target.
 * Your task is to return a list of all unique combinations of candidates where the chosen numbers sum to target.
 * Each element from candidates may be chosen at most once within a combination. The solution set must not contain duplicate combinations.
 * You may return the combinations in any order and the order of the numbers in each combination can be in any order.
 *
 *
 * Time Complexity: O(n * 2^n)  n: Size of input array
 * Space Complexity: O(n)
 *
*/

public class Solution {
    List<List<int>> res = new List<List<int>>();

    public List<List<int>> CombinationSum2(int[] candidates, int target) {
        Array.Sort(candidates);

        backtrack(candidates, target, 0, 0, new List<int>());

        return res;
    }

    private void backtrack(int[] candidates, int target, int index, int sum, List<int> array) {
        if (sum == target) {
            res.Add(array.ToList());
            return;
        }
            
        if ((sum > target) || (index == candidates.Length)) {
            return;
        }

        array.Add(candidates[index]);        
        backtrack(candidates, target, index + 1, sum + candidates[index], array);
        array.RemoveAt(array.Count - 1);

        while (index + 1 < candidates.Length && candidates[index] == candidates[index+1])
        {
            index++;
        }  

        backtrack(candidates, target, index + 1, sum, array);
    }   
}

