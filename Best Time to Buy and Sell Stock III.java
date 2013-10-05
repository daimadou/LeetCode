public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int []buy = new int[prices.length];
        int maxVal = Integer.MIN_VALUE;
        int maxprofit = 0;
        for(int i = prices.length-1; i >-1 ; i--)
        {
            if(prices[i] > maxVal)
            {
                maxVal = prices[i];    
            } 
            int val = maxVal - prices[i];
            maxprofit = Math.max(val, maxprofit);
            buy[i] = maxprofit; 
        } 
        
        maxprofit = 0; 
        int minVal = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++)
        {
            if(prices[i] < minVal)
            {
                minVal = prices[i];
            } 
            int val = prices[i] - minVal;
            maxprofit = Math.max(maxprofit, val + buy[i]);
        }
        
        return maxprofit;
    }
}