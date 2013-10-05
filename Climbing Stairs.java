public class Solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n==0)
        {
            return 0;
        }
        int []dp = new int[2];
        dp[0] = 1;
        dp[1] = 1;
        int ret = 1;
        for(int i = 1; i < n; i++)
        {
            ret = dp[0] + dp[1];
            dp[1] = dp[0];
            dp[0] = ret;
        }
        
        return ret;
    }
}