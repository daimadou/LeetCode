class Solution {
public:
    int minimumTotal(vector<vector<int> > &triangle) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<int> row(triangle.size()+1, 0);
        
        const int R = triangle.size();
        for(int i = R-1; i>-1; i--)
        {
            const int C = triangle[i].size();
            for(int j = 0; j < C; j++)
            {
                row[j] = row[j]<row[j+1]? row[j]:row[j+1];
                row[j] += triangle[i][j];
            }
        }
        
        
        return row[0];
    }
};
