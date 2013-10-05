public class Solution {
    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n < 1)
        {
            return 0;
        }
        
        int []dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1; i < n+1; i++)
        {
            for(int j=0; j<i; j++)
            {
                dp[i] += dp[i-j-1] * dp[j];
            }
        }
        
        return dp[n];
    }
}