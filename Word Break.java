public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        boolean[] dp = new boolean[s.length() + 1]; 
        for(int i = 1; i < s.length() + 1; i++)
        {
            dp[i] = dict.contains(s.substring(0, i))||dp[i];
            if(dp[i])
            {
                for(int j = i + 1; j < s.length() + 1; j++)
                {
                    dp[j] = dict.contains(s.substring(i, j))||dp[j];
                }
            }
        }
        return dp[s.length()];
    }
}