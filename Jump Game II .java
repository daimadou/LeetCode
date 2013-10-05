public class Solution {
    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length==0)
        {
            return 0;
        }
        
        int maxJumpToIndex = 0;
        int nextMaxJumpToIndex = 0;
        int steps = -1;
        for(int i = 0; i < A.length; i++)
        {
            nextMaxJumpToIndex = Math.max(nextMaxJumpToIndex, i + A[i]);
            if(i == maxJumpToIndex || i == (A.length-1))
            {
                maxJumpToIndex = nextMaxJumpToIndex;
                steps++;
            }
        }
        return steps;
    }
}