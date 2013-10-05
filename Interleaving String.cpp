class Solution {
public:
    bool isInterleave(string s1, string s2, string s3) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function    
        int m = s1.size();
        int n = s2.size();
        int len = s3.size();
        if(m+n != len)
            return false;
        
        vector<bool> dp(n+1, false);
        dp[0] = true;
        for(int i = 1; i <= n; i++)
        {
            dp[i] = (s3[i-1]==s2[i-1]&&dp[i-1]);
        }
        
        for(int i = 1; i <= m; i++)
        {
            dp[0] = (s3[i-1]==s1[i-1])&&dp[0];
            for(int j = 1; j <= n; j++)
            {
                dp[j] = ((s3[i+j-1]==s2[j-1])&&dp[j-1])||(s3[i+j-1]==s1[i-1]&&dp[j]);
            }
        }
        
        return dp[n];
    }
};