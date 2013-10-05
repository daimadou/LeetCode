public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(matrix.length == 0||matrix[0].length == 0)
        {
            return false;
        }
        boolean ret = false;
        int i = 0;
        int j = matrix[0].length - 1;
        while(i < matrix.length&& j > -1)
        {
            if(matrix[i][j]==target)
            {
                ret = true;
                break;
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
        
        return ret;
    }
    
}