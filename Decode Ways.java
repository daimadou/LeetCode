public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.isEmpty())
        {
            return 0;   
        }
        int []dp = new int[2];
        int preDigit = s.charAt(s.length() - 1) - '0';
        dp[1] = 1;
        dp[0] = preDigit > 0? 1:0;
       
        for(int i = s.length() - 2; i > -1; i--)
        {
            int oneDigit = (s.charAt(i) - '0');
            int twoDigit = oneDigit*10 + preDigit;
            if( oneDigit == 0)
            {
                dp[1] = dp[0];
                dp[0] = 0;
                continue;
            }
            int predp = dp[0];
            if( twoDigit > 9 && twoDigit <= 26)
            {
                dp[0] += dp[1];
            }
            preDigit = oneDigit;
            dp[1] = predp;
        }
        
        return dp[0];
    }
}