class Solution {
public:
    int numDecodings(string s) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(s.empty())
            return 0;
        
        vector<int> dp(2, 1);
        int pre = 0;
        int len = s.size();
        int num = 0;
        dp[1] = 1;
        int digit  = s[len-1] - '0';
        
        /*
        for dp question, it is not hard to write equation. 
        However the intial value shoule be think twice. Should we start from the first or last or the second or the second from the last
        We should be careful about that!!!!
        */
        
        
        if(digit==0)
        {
            dp[0] = 0;
        }
        else
        {
            dp[0] = 1; 
        }
       
        pre = digit;
        for(int i = len-2; i > -1; i--)
        {
            digit  = s[i] - '0';
            num = pre+10*digit;
            if(digit==0)
            {
                dp[1] = dp[0];
                dp[0] = 0;
                continue;
               
            }
            
            int preDp = dp[0];
            if(num>=10&&num <=26)
                dp[0] +=dp[1];
            dp[1] = preDp;
            pre = digit;
            
        }
        
        return dp[0];
    }
};