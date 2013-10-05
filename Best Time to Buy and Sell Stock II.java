public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function

        int maxprofit = 0; 
        for(int i = 1; i < prices.length; i++)
        {
            if(prices[i-1]<prices[i])
            {
                maxprofit += prices[i] - prices[i-1];
            }
        }
        
        return maxprofit;
    }
}