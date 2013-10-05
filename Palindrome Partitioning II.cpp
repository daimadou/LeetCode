class Solution {
public:
    int minCut(string s) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<vector<bool>> part(s.size(), vector<bool>(s.size(),false));
        
        const int len = s.size();
        int i = 0;
        for(i = len-1; i > -1; i--)
        {
            int j = 0;
            for(j = i; j<len; j++)
            {
                part[i][j] = (((j-i<2)||(part[i+1][j-1]))&&(s[i]==s[j]))?true:false;
            }
        }
        
        vector<int> cuts(s.size()+1, INT_MAX);
        cuts[len] = -1;
        for(i = len-1; i > -1; i--)
        {
            int j = 0;
            for(j = i; j<len; j++)
            {
                if(part[i][j])
                    cuts[i] = min(cuts[i], 1+cuts[j+1]);
            }
        }
        
        return cuts[0];
    }
};