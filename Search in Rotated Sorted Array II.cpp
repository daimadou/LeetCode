class Solution {
public:
    bool search(int A[], int n, int target) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        return search(A, 0, n-1, target);
    }
    
    bool search(int A[], int left, int right, int target)
    {
        if(left>right)
            return false;
        
        int mid = (left+right)/2;
        if(A[mid]==target)
            return true;
        
        int leftVal = A[left];
        int rightVal = A[right];
        bool flag = false;
        if(leftVal < A[mid])
        {
            if(target < A[mid]&&target >= leftVal)
                return search(A, left, mid-1, target);
            else
                return search(A, mid+1, right, target);
        }
        else if(A[mid] < rightVal)
        {
            if(target > A[mid]&&target <= rightVal)
                return search(A, mid+1, right, target);
            else
                return search(A, left, mid-1, target);
        }
        else
        {
            if(A[mid] != leftVal)
            {
                return search(A, left, mid-1, target);
            }
            else if(A[mid] != rightVal)
            {
                return search(A, mid+1, right, target);
            }
            else
            {
                flag = search(A, left, mid-1, target);
                if(flag)
                {
                    return true;
                }
                else
                {
                    return search(A, mid+1, right, target);
                }
            }
        }
    }
};