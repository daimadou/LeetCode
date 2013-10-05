public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length == 0)
        {
            return 0;
        }
        int count = 0;
        int pos = 0;
        int preVal = A[0]-1;
        for(int i = 0; i < A.length; i++)
        {
            if(A[i]==preVal)
            {
                count++;
            }
            if(A[i]!=preVal || count<2)
            {
                A[pos] =  A[i];
                pos++;
                if(A[i]!=preVal)
                {
                    count = 0;   
                }
            }
            preVal = A[i];
        }
        
        return pos;
        
    }
}