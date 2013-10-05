class Solution {
public:
    vector<vector<int> > subsetsWithDup(vector<int> &S) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        
        
        //when we initialize double vector, use the way below!!!!
        vector<vector<int> > result(1, vector<int>(0));
        sort(S.begin(), S.end());
        
        int count = 1;
        int i = 0;
        
        for(i = 1; i<S.size(); i++)
        {
            if(S[i-1]!=S[i])
            {
                mergeVal(S[i-1], count, result);
                count = 1;
            }
            else
            {
                count++;
            }
        }
        
        mergeVal(S[i-1], count, result);
        return result;
    }
    
    
    
    
    void mergeVal(int val, int count, vector<vector<int>> &result)
    {
        vector<vector<int>> resultCopy(result);
        for(int i=0; i < count; i++)
        {
            for(vector<int> &oneResult:resultCopy)
            {
                oneResult.push_back(val);
                result.push_back(oneResult);
            }
        }
    }
};