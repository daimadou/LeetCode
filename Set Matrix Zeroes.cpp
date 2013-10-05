class Solution {
public:
    void setZeroes(vector<vector<int> > &matrix) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(matrix.empty())
            return;
       
        int C = matrix[0].size();
        int R = matrix.size();
        bool setFirstCol = false;
        bool setFirstRow = false;
        
        for(int i = 0; i < R; i++)
        {
            for(int j = 0; j < C; j++)
            {
                if(matrix[i][j]==0)
                {
                    if(i==0)
                        setFirstRow = true;
                    if(j==0)
                        setFirstCol = true;
                        
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(int i = 1; i < R; i++)
        {
            if(matrix[i][0]==0)
            {
                for(int j = 1; j < C; j++)
                {
                    matrix[i][j] = 0;
                }
            }
        }
        
        for(int j = 1; j < C; j++)
        {
            if(matrix[0][j]==0)
            {
                for(int i = 1; i < R; i++)
                {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(setFirstRow)
        {
            for(int i = 0; i < C; i++)
            {
                matrix[0][i] = 0;
            }
        }
        
        if(setFirstCol)
        {
            for(int i = 0; i < R; i++)
            {
                matrix[i][0] = 0;
            }
        }
    }
};
