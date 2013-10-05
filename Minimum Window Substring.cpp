class Solution {
public:
    string minWindow(string S, string T) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        string result;
        if(S.empty()||T.empty())
            return result;
        
        vector<int> record(255, 0);
        for(int i = 0; i < T.size(); i++)
        {
            record[T[i]]++;
        }
        
        int start = 0;
        int end = 0;
        
        int size = 0;
        vector<int> check(255, 0);
        int maxLen = INT_MAX;
        int maxStart = 0;
        int maxEnd = 0;
        for(int i = 0; i < S.size(); i++)
        {
            check[S[i]]++;
            if(check[S[i]] <=  record[S[i]]&&record[S[i]] > 0)
            {
                size++;
            }
            
            if(size == T.size())
            {
                end = i;
                while(start <= end)
                {
                    char c = S[start];
                    if(check[c] > record[c]&&record[c]>0)
                        check[c]--;
                    else if(check[c] == record[c] && record[c]>0)
                    {
                        int len = end - start + 1;
                        if(len < maxLen)
                        {
                            maxLen = len;
                            maxStart = start;
                            maxEnd = end;
                        }
                        break;
                    }
                    start++;
                }
            }
        }
        
        if(maxLen == INT_MAX)
            return S.substr(0,0);
        else
            return S.substr(maxStart, maxLen);
    }
