public class Solution {
    public List<List<int>> ThreeSum(int[] nums) {
        Array.Sort(nums);

        HashSet<Tuple<int, int, int>> uniqueTriplets = new HashSet<Tuple<int, int, int>>();
        List<List<int>> res = new List<List<int>>();
        
        for (int i = 0;i < nums.Length;i++)
        {
            int j = i+1;
            int k = nums.Length-1;
            int target = -nums[i];
            while(j < k)
            {
                if (nums[j] + nums[k] == target)
                {
                    var tuple = Tuple.Create(nums[i], nums[j], nums[k]);
                    uniqueTriplets.Add(tuple);
                    j++;
                }
                else if (nums[j] + nums[k] > target)
                {
                    k--;
                }
                else 
                {
                    j++;
                }
            }
        }

        foreach (var triplet in uniqueTriplets)
        {
            res.Add(new List<int> { triplet.Item1, triplet.Item2, triplet.Item3 });
        }

        return res;
    }
}
