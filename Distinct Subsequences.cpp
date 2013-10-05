class Solution {
public:
    int numDistinct(string S, string T) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<int> dp(T.size()+1, 0);
        dp[0] = 1;
        
        const int n = S.size();
        const int m = T.size();
        
        for(int i = 0; i < n; i++)
        {
            for(int j = m-1; j>-1; j--)
            {
                if(S[i]==T[j])
                    dp[j+1] = dp[j]+dp[j+1];
            }
            
        }
        
        return dp[T.size()];
    }
};