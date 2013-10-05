public class Solution {
    public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length == 0)
        {
            return 0;
        }
        int []left = new int[A.length];
        int leftMax = A[0];
        int rightMax = A[A.length-1];
        int ret = 0;
        for(int i=0; i<A.length; i++)
        {
            if(A[i]>=leftMax)
            {
                leftMax = A[i];
            }
            left[i] = leftMax; 
        }
        
        for(int i= A.length-1; i>-1; i--)
        {
            if(A[i]>=rightMax)
            {
                rightMax = A[i];
            }
            if(A[i]!=rightMax&&A[i]!=left[i])
            {
                ret += Math.min(rightMax, left[i]) - A[i]; 
            }
        }
        
        return ret;
    }
}