class Solution {
public:
    vector<vector<int> > generate(int numRows) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<int> pre(1, 1);
        vector<vector<int> > result;
        
        for(int i = 0; i< numRows; i++)
        {
            vector<int> row(i+1);
            for(int j = 1; j < i; j++)
            {
                row[j] = pre[j-1] + pre[j];
            }
            row[0] = 1;
            row[i] = 1; 
            result.push_back(row);
            pre = row;
        }
        
        return result;
        
    }
};