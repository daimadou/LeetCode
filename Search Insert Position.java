public class Solution {
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return search(A, 0, A.length-1, target);
    }
    
    private int search(int[] A, int left, int right, int target)
    {
        if(left > right)
        {
            return -1;
        }
        
        int mid = (left + right)/2;
        if(target == A[mid])
        {
            return mid;
        }
        else if(target < A[mid])
        {
            int index = search(A, left, mid - 1, target);
            if(index == -1)
            {
                index = mid;
            }
            return index;
        }
        else
        {
            int index = search(A, mid + 1, right, target);
            if(index == -1)
            {
                index = mid + 1;
            }
            return index;
        }
    }
}
