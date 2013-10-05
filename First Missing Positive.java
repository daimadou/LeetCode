public class Solution {
    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length == 0)
        {
            return 1;
        }
        
        for(int i = 0; i < A.length; i++)
        {
            if(A[i] > 0 && A[i] <= A.length && A[A[i] - 1] != A[i])
            {
                int index = A[i] - 1;
                int val = A[index];
                A[index] = A[i];
                A[i] = val;
                i--;
            }
        }
        
        int ret = A.length+1;
        for(int i = 0; i < A.length; i++)
        {
            if(A[i]!=i+1)
            {
                ret = i+1;
                break;
            }
        }
        return ret;
    }
}