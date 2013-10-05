class Solution {
public:
    int removeDuplicates(int A[], int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(n==0)
            return 0;
        
        int count = 0;
        int cur = 0;
        for(int i = 1; i < n; i++)
        {
            if(A[i-1]!=A[i])
            {
                cur++;
                A[cur] = A[i];
                count = 0;
            }
            else
            {
                if(count==0)
                {
                    cur++;
                    A[cur] = A[i];
                    count++;
                }
            }
        }
        
        return cur+1;
    }
};