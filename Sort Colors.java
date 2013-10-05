public class Solution {
    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i = 0;
        int redEnd = 0;
        int blueStart = A.length-1;
        while(i <= blueStart)
        {
            if(A[i] == 0)
            {
                int val = A[redEnd];
                A[redEnd] = A[i];
                A[i] = val;
                redEnd++;
                i++;
            }
            else if(A[i]==1)
            {
                i++;
            }
            else
            {
                int val = A[blueStart];
                A[blueStart] = A[i];
                A[i] = val;
                blueStart--;
            }
        }
    }
}