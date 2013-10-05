public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(matrix.length==0||matrix[0].length==0)
        {
            return ret;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int nNum = n; 
        int mNum = m;
        int offset = 0;
        while(mNum > 0 && nNum > 0)
        {
           
            if(nNum==1)
            {
                for(int i = 0 ; i < mNum; i++)
                {
                     ret.add(matrix[offset+i][offset]);
                }
                break;
            }
            
            if(mNum==1)
            {
                for(int i = 0 ; i < nNum; i++)
                {
                     ret.add(matrix[offset][offset+i]);
                }
                break;
            }
            
            for(int i = 0 ; i < nNum-1; i++)
            {
                 ret.add(matrix[offset][offset+i]);
            }
            for(int i = 0 ; i < mNum-1; i++)
            {
                 ret.add(matrix[offset + i][n - 1 - offset]);
            } 
            for(int i = 0 ; i < nNum-1; i++)
            {
                 ret.add(matrix[m - 1 - offset][n - 1 - offset -i]);
            }
            for(int i = 0 ; i < mNum-1; i++)
            {
                 ret.add(matrix[m - 1 - offset - i][offset]);
            }
            
            offset++;
            nNum = n - 2*offset;
            mNum = m - 2*offset;
        }
        
        return ret;
    }
}