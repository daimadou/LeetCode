public class Solution {
    public boolean search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length == 0)
        {
            return false;
        }
        else
        {
            return search(A, 0, A.length - 1, target);
        }
    }
    
    public boolean search(int[] A, int start, int end, int target)
    {
        if(start > end)
        {
            return false;
        }
        
        int mid = (start + end)/2;
        if(A[mid] == target)
        {
            return true;
        }
        
        int left = A[start];
        int right = A[end];
        if(A[mid] < A[end])
        {
            if(target>A[mid] && target <= A[end])
            {
                return search(A, mid + 1, end, target);
            }
            else
            {
                return search(A, start, mid - 1, target);
            }
        }
        else if(A[mid] > A[start])
        {
            if(target<A[mid] && target >= A[start])
            {
                return search(A, start, mid -1, target);
            }
            else
            {
                return search(A, mid + 1 , end, target);
            }
        }
        else
        {
            if(A[mid] != A[end])
            {
                return search(A, mid + 1, end, target);
            }
            else if(A[mid] != A[start])
            {
                return search(A, start, mid - 1, target);
            }
            else
            {
                return search(A, start, mid - 1, target)? true:search(A, mid + 1, end, target);
            }
        }
    }
}