public class Solution {
    public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(matrix.length==0||matrix[0].length==0)
        {
            return;
        }
        
        boolean clearFirstRow = false;
        boolean clearFirstCol = false;
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                if(matrix[i][j]==0)
                {
                    if(!clearFirstCol && j==0)
                    {
                        clearFirstCol = true;
                    }
                    if(!clearFirstRow && i==0)
                    {
                        clearFirstRow = true;
                    }
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        for(int i = 1; i < matrix.length; i++)
        {
            for(int j = 1; j < matrix[0].length; j++)
            {
                if(matrix[0][j] == 0||matrix[i][0] == 0)
                {
                    matrix[i][j] = 0;
                }
            }
        }
        if(clearFirstRow)
        {
            for(int i = 0; i < matrix[0].length; i++)
            {
                matrix[0][i] = 0;
            }
        }
        if(clearFirstCol)
        {
            for(int i = 0; i < matrix.length; i++)
            {
                matrix[i][0] = 0;
            }
        }
        
        return;
    }
}