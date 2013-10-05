public class Solution {
    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(m == 0 || n == 0)    
        {
            return 0;
        }
        
        int []dp = new int[n+1];
        Arrays.fill(dp, 1);
        dp[0] = 0;
        for(int i = 1; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                dp[j+1] = dp[j] + dp[j+1];   
            }
        }
        
        return dp[n];
    }
}