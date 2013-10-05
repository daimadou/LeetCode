public class Solution {
    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(grid.length==0||grid[0].length==0)
        {
            return 0;
        }
        
        int []dp = new int[grid[0].length + 1];
        for(int i = 0; i < grid[0].length; i++)
        {
            dp[i+1] = dp[i] + grid[0][i];
        }
        dp[0] = Integer.MAX_VALUE;
    
        for(int i = 1; i < grid.length; i++)
        {
            for(int j = 0; j <grid[0].length; j++)
            {
                int val = Math.min(dp[j+1], dp[j]);
                dp[j+1] = val + grid[i][j];
            }
        }
        
        return dp[grid[0].length];
    }
}