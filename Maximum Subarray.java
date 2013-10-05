public class Solution {
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return maxSubArray(A, 0, Integer.MIN_VALUE);
    }
    
    public int maxSubArray(int[] A, int index, int max)
    {
        if(index == A.length)
        {
            return max;
        }
        
        int val = 0;
        while( index < A.length && val >= 0)
        {
            val += A[index];
            max = Math.max(val, max);
            index++;
        }
        return maxSubArray(A, index, max);
    }
}