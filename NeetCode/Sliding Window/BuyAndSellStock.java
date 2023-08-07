class BuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int max = 0;

        while(right < prices.length) {
            if(prices[left] < prices[right]) {
                int profit = prices[right] - prices[left];
                max = Math.max(max, profit);
            } else {
                left = right;
            }
            right++;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println(maxProfit(prices));
    }
}