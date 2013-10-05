public class Solution {
    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length == 0)
        {
            return false;
        }
        
        int i = 0;
        int maxJumpToIndex = 0;
        while(i < A.length && i <= maxJumpToIndex)
        {
            int index = A[i] + i;
            maxJumpToIndex = Math.max(index, maxJumpToIndex);
            i++;
        }
        return i==(A.length);
    }
}