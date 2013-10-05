public class Solution {
    public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length == 0)
        {
            return -1;
        }
        
        return search(A, 0, A.length - 1, target);
    }
    
    public int search(int[] A, int left, int right, int target)
    {
        if(left > right)
        {
            return -1;
        }
        
        int mid = (left + right)/2;
        if(A[mid] == target)
        {
            return mid;
        }
        else if(A[mid] > target)
        {
            if((A[right]>A[mid])||((A[left] < A[mid]) && (target >= A[left])))
            {
                return search(A, left, mid - 1, target);
            }
            else
            {
                return search(A, mid + 1, right, target);
            }
        }
        else 
        {
            if((A[left] < A[mid]) || ((A[right] > A[mid]) && (A[right]>=target)))
            {
                return search(A, mid + 1, right, target);
            }
            else
            {
                return search(A, left, mid - 1, target);
            }
        }
    }
}