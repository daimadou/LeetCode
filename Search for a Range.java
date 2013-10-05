public class Solution {
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return search(A, 0, A.length - 1, target);
    }
    
    private int[] search(int[] A, int left, int right, int target)
    {
        int[] range = {-1,-1};
        if(left > right)
        {
            return range;
        }
        
        int mid = (left + right)/2;
        if(A[mid] == target)
        {
            
            if(A[mid]==A[left])
            {
                range[0] = left;
            }
            else if(A[mid] != A[mid-1])
            {
                range[0] = mid;
            }
            else
            {
                 int[] rangeLeft = search(A, left, mid-1, target);
                 range[0] = rangeLeft[0];
            }
            
            if(A[mid]==A[right])
            {
                range[1] = right;
            }
            else if(A[mid]!=A[mid+1])
            {
                range[1] = mid;
            }
            else
            {
                int[] rangeRight = search(A, mid+1, right, target);
                range[1] = rangeRight[1];
            }
            
            return range;
        }
        else if(target < A[mid])
        {
            return search(A, left, mid-1, target);
        }
        else
        {
            return search(A, mid+1, right, target);
        }
    }
}