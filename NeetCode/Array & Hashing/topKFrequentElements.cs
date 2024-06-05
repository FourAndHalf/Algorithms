public class Solution {
    public int[] TopKFrequent(int[] nums, int k) {
        Dictionary<int, int> map = new Dictionary<int, int>();
        List<int>[] freq = new List<int>[nums.Length + 1];

        for(int i = 0; i< freq.Length; i++) {
            freq[i] = new List<int>();
        }

        foreach (int n in nums) {
            if(map.ContainsKey(n)) {
                map[n]++;
            } else {
                map[n] = 1;
            }
        }

        foreach (var entry in map) {
            freq[entry.Value].Add(entry.Key);
        }

        int[] res = new int[k];
        int index = 0;
        for(int i = freq.Length - 1;i > 0 && index < k; i--) {
            foreach (int n in freq[i]) {
                res[index++] = n;
                if(index == k) {
                    return res;
                }
            }
        }

        return res;
    }
}
