public class Solution {
    public int maximalRectangle(char[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(matrix.length==0||matrix[0].length==0)
        {
            return 0;
        }
        
        int length = matrix[0].length;
        int height = matrix.length;
        int []left = new int[length];
        int []right = new int[length];
        Arrays.fill(right, length);
        int []hmax = new int[length];
        int ret = 0;
        for(int i = 0; i < height; i++)
        {
            int l = 0;
            int r = length;
            for(int j = 0; j < length; j++)
            {
                if(matrix[i][j]=='1')
                {
                    left[j] = Math.max(left[j], l);
                    hmax[j]++;
                }
                else
                {
                    left[j] = 0;
                    l = j+1;
                    hmax[j] = 0;
                }
            }
            
            for(int j = length -1; j > -1; j-- )
            {
                if(matrix[i][j]=='1') 
                {
                    right[j] = Math.min(right[j], r);
                    ret = Math.max(ret, hmax[j]*(right[j]-left[j]));
                }
                else
                {
                    r = j;
                    right[j] = length;
                }
            }
            
        }
        
        return ret;
        
    }
}