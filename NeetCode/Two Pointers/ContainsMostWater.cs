/*   Two Pointer Solution     */

public class Solution {
    public int MaxArea(int[] heights) {
        int res = 0;
        int left = 0, right = heights.Length-1;

        while(left < right) 
        {
            int area = (Math.Min(heights[left], heights[right]) * (right - left));
            res = Math.Max(res, area);

            if (heights[left] <= heights[right])
            {
                left++;
            }
            else 
            {
                right--;
            }
        }

        return res;
    }
}

// Time Complexity = O(n)
// Space Complexity = O(1)
