public class Solution {
    public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char []s = S.toCharArray();
        char []t = T.toCharArray();
        int len = T.length();
        int []dp = new int[len+1];
        dp[0] = 1;
        for(int i = 0; i < S.length(); i++)
        {
            for(int j = T.length()-1; j > -1; j--)
            {
                if(s[i]==t[j])
                {
                    dp[j+1] = dp[j+1] + dp[j];
                }
            }
        }
        
        return dp[len];
        
    }
}