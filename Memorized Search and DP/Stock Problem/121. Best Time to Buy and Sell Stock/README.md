[121. Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/)

Simple and straight forward solution.

```
class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int profit = 0;
        for(int i = 0; i < prices.length;i ++)
        {
            min = Math.min(min, prices[i]);
            profit = Math.max(prices[i] - min, profit);
        }
        return profit;
    }
}
```
