public class Solution
{
    public int MaxProfit(int[] prices)
    {
        int left = 0;
        int right = 1;
        int max = 0;
        int profit = 0;

        while (right <= prices.Length - 1)
        {
            if (prices[left] < prices[right])
            {
                profit = prices[right] - prices[left];
                if (max < profit)
                    max = profit;
            }
            else
            {
                left = right;
            }

            right++;
        }

        return max;
    }

    public int MaxProfitSimplified(int[] prices)
    {
        int minPrice = int.MaxValue;
        int maxProfit = 0;

        foreach (int price in prices)
        {
            if (price < minPrice)
            {
                minPrice = price;
            }

            int profit = price - minPrice;

            if (profit > maxProfit)
            {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }
}

