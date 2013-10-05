public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = triangle.size();
        int []dp = new int[n+1];   
        for(int i = n-1; i > -1; i--)
        {      
            for(int j=0; j < triangle.get(i).size(); j++)
            {
                int val = (int)triangle.get(i).get(j);
                dp[j] = val + Math.min(dp[j], dp[j+1]);
            }
        }
        return dp[0];
    }
}