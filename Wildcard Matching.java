public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.length() == 0 && p.length() == 0)
        {
            return true;
        }
        else if(s.length() != 0 && p.length() == 0)
        {
            return false;
        }
        
        char []sChars = s.toCharArray();
        char []pChars = p.toCharArray();
        boolean []dp = new boolean[s.length()+1];
        dp[0] = true;
        int nonStarChars = 0;
        for(char c: pChars)
        {
            if(c != '*')
            {
                nonStarChars++;
            }
        }
        if(nonStarChars > s.length())
        {
            return false;
        }
        
        for(int i = 0; i < p.length(); i++)
        {
            if(pChars[i] != '*')
            {
                for(int j = s.length() - 1; j > -1; j--)
                {
                    dp[j+1] = (pChars[i]=='?' || pChars[i]==sChars[j])&&dp[j];
                }
                dp[0] = false;
            }
            else
            {
                int start = -1;
                for(int j = s.length() - 1; j > -1; j--)
                {
                    dp[j+1] = dp[j+1]||dp[j];
                    if(dp[j+1])
                    {
                        start = j;
                    }
                }
                if(start != -1)
                {
                    for(int j = start; j < s.length(); j++)
                    {
                        dp[j+1] = true;
                    }
                }
            }
        }
        
        return dp[s.length()];
    }
}