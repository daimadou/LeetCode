public class Solution {
    public int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n==0)
        {
            return new int[0][0];
        }
        
        int [][]matrix = new int[n][n];
        int count = 0;
        for(int offset = 0; offset < n/2; offset++)
        {
            int start = 0 + offset;
            int end = n - 1 - offset;
            int num = end - start;
            for(int i = 0; i < num; i++)
            {
                matrix[start][start + i] = ++count;
            }
            for(int i = 0; i < num; i++)
            {
                matrix[start + i][end] =  ++count;
            }
            for(int i = 0; i < num; i++)
            {
                matrix[end][end-i] = ++count;
            }
            for(int i = 0; i < num; i++)
            {
                matrix[end-i][start] = ++count;
            }
        }
        if(n%2==1)
        {
            matrix[n/2][n/2] = ++count;
        }
        return matrix;
    }
}