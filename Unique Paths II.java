public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(m == 0 || n == 0)    
        {
            return 0;
        }
        
        int []dp = new int[n+1];
        dp[0] = 1;
        for(int i = 0; i < n; i++)
        {
            dp[i+1] = obstacleGrid[0][i]==1? 0:dp[i];
        }
        
        dp[0] = 0;
        for(int i = 1; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                dp[j+1] = obstacleGrid[i][j]==1? 0 : dp[j]+dp[j+1];
            }
        }
        
        return dp[n];
    }
}