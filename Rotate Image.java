public class Solution {
    public void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(matrix.length==0 || matrix[0].length== 0)
        {
            return;
        }
        
        int n = matrix.length;
        for(int offset = 0; offset < n/2; offset++)
        {
            int num = n - 2*offset;
            int start = 0 + offset;
            int end = n - 1 - offset; 
            for(int i = 0; i < num -1; i++)
            {
                int val = matrix[start][start + i];
                matrix[start][start + i] = matrix[end - i][start];
                matrix[end - i][start] = matrix[end][end - i];
                matrix[end][end - i] = matrix[start + i][end];
                matrix[start + i][end] = val;
            }
        }
    }
}