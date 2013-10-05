public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int minVal = Integer.MAX_VALUE;
        int maxprofit = 0;
        for(int i:prices)
        {
            if(i < minVal)
            {
                minVal = i;
            }
            maxprofit = Math.max(maxprofit, i - minVal);
        }
        
        return maxprofit;
    }
}