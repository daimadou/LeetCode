class Solution {
public:
    void merge(int A[], int m, int B[], int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int A_counter = m-1;
        int B_counter = n-1;
        
        for(int i = m+n-1; i > -1; i--)
        {
            int numA = (A_counter>-1)?A[A_counter]:INT_MIN;
            int numB = (B_counter>-1)?B[B_counter]:INT_MIN;
            if(numA > numB)
            {
                A[i] = numA;
                A_counter--;
            }
            else
            {
                A[i] = numB;
                B_counter--;
            }
        }
    }
};