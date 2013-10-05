class Solution {
public:
    vector<int> getRow(int rowIndex) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<int> row;
        if(rowIndex<0)
            return row;
        
        row = vector<int>(rowIndex+1);
        for(int i = 0; i< rowIndex+1; i++)
        {
            for(int j = i-1; j >0; j--)
            {
                row[j] = row[j-1] + row[j];
            }
            row[0] = 1;
            row[i] = 1; 
        }
        
        return row;
    }
};