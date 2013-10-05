public class Solution {
    public boolean isScramble(String s1, String s2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = s1.length();
        boolean [][][]dp = new boolean[len][len][len + 1];
        for(int i = s1.length() - 1; i > -1;  i--)
        {
            for(int j = s2.length() - 1; j > -1; j--)
            {
                int index = Math.max(i, j);
                int K = len - index;
                for(int k = 1; k <= K; k++)
                {   
                    String sub1 = s1.substring(i, i+k);
                    String sub2 = s2.substring(j, j+k);
                    if(sub1.equals(sub2))
                    {
                        dp[i][j][k] = true;
                    }
                    else
                    {
                        for(int l= 1; l < k; l++)
                        {
                            dp[i][j][k] = (dp[i][j][l]&&dp[i+l][j+l][k-l])||(dp[i+l][j][k-l]&&dp[i][j+k-l][l]);
                            if(dp[i][j][k])
                            {
                                break;
                            }
                        }
                    }
                }            
            }
        }
        
        return dp[0][0][len];
    }
}