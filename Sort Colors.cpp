class Solution {
public:
    void sortColors(int A[], int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(n == 0)
            return;
        
        int i = 0;
        int j = n - 1;
        int redStart = 0;
        int endBlue = n - 1;
        
        while(i <= endBlue)
        {
            if(A[i]==0)
            {
                int temp = A[redStart];
                A[redStart] = A[i];
                A[i] = temp;
                redStart++;
                i++;
            }
            else if(A[i] == 1)
            {
                i++;
            }
            else
            {
                int temp = A[endBlue];
                A[endBlue] = A[i];
                A[i] = temp;
                endBlue--;
            }
        }
    }
};
