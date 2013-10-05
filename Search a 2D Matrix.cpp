class Solution {
public:
    bool searchMatrix(vector<vector<int> > &matrix, int target) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(matrix.empty())
            return false;
        
        int colum = matrix[0].size();
        int row = matrix.size();
        int i = 0;
        int j = colum - 1;
        while(i < row && j > -1)
        {
            if(matrix[i][j]==target)
            {
                return true;
            }
            else if(matrix[i][j] > target)
            {
                j--;
            }
            else
            {
                i++;
            }
        }
        
        return false;
    }
};
