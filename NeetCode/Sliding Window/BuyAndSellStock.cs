public class Solution {
    public int MaxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int max = 0;
        int profit = 0;

        while (right <= prices.Length - 1) {
            if (prices[left] < prices[right]) {
                profit = prices[right] - prices[left];
                if (max < profit) 
                    max = profit;
            } else {
                left = right;
            }

            right++;
        }

        return max;
    }
}

