class Solution {
public:
    bool isScramble(string s1, string s2) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int m = s1.size();
        int n = s2.size();
        if(m != n)
            return false;
        
        //int k = m+n;
        
        vector<vector<vector<bool>>>dp(n, vector<vector<bool>>(n, vector<bool>(n+1, false)));
        
        for(int i = n-1; i > -1; i--)
        {
            for(int j = n-1; j > -1; j--)
            {
                int size = n-max(i, j);
                for(int k = 1; k <= size; k++)
                {
                    string tempS1 = s1.substr(i, k);
                    string tempS2 = s2.substr(j, k);
                    if(tempS1 == tempS2)
                    {
                        dp[i][j][k] = true;
                    }
                    else
                    {
                        for(int l = 1; l < k; l++)
                        {
                            dp[i][j][k] = (dp[i][j][l]&&dp[i+l][j+l][k-l])||(dp[i][j+k-l][l]&&dp[i+l][j][k-l]);
                            if(dp[i][j][k])
                                break;
                        }
                    }
                }
            }
        }
        
        return dp[0][0][n];
        
    }
};