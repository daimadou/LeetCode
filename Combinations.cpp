class Solution {
public:
    vector<int> oneResult;
    vector<vector<int>>results;
    vector<vector<int> > combine(int n, int k) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        oneResult.clear();
        results.clear();
        buildCombination(1, n, k);
        return results;
    }
    
    
    void buildCombination(int index, int n, int k)
    {
        if(k==0)
        {
            results.push_back(oneResult);
            return;
        }
        
        for(int i = index; i <= n; i++)
        {
            oneResult.push_back(i);
            buildCombination(i+1, n, k-1);
            oneResult.pop_back();
        }
    }
};
