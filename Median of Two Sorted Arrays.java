public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = A.length;
        int n = B.length;
        if((m+n)%2 == 0)
        {
            return (findKth(A, 0, m, B, 0, n, (m+n) / 2) + findKth(A, 0, m, B, 0, n, ( m + n) / 2 + 1)) / 2;
        }
        else
        {
            return findKth(A, 0, m, B, 0, n, (m+n)/2 + 1);
        }
    }
    
    double findKth(int A[], int offsetA, int m, int B[], int offsetB, int n, int k) {
        if(m > n)
        {
            return findKth(B, offsetB, n,  A, offsetA, m, k); 
        }
        else if(n==0)
        {
            return A[k-1];
        }
        else if(m==0)
        {
            return B[k-1];
        }
        else if(k==1)
        {
            return Math.min(A[offsetA], B[offsetB]);
        }
        else
        {
            int aMid = Math.min(m, k/2);
            int bMid = k - aMid;
            if(A[offsetA + aMid-1] < B[offsetB + bMid-1])
            {
                return findKth(A, offsetA + aMid, m - aMid, B, offsetB, n, k - aMid);
            } 
            else
            {
                return findKth(A, offsetA, m, B, offsetB + bMid, n - bMid, k - bMid);
            }
        }
        
    }
}