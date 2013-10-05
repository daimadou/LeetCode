public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int countA = m-1;
        int countB = n-1;
        for(int i = m + n -1; i> -1; i--)
        {
            int a = (countA > -1)? A[countA]:Integer.MIN_VALUE;
            int b = (countB > -1)? B[countB]:Integer.MIN_VALUE;
            if(a > b)
            {
                A[i] = a;
                countA--;
            }
            else
            {
                A[i] = b;
                countB--;
            }
        }
    }
}