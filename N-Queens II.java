public class Solution {
    int sum;
    public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n == 0)
        {
            return 0;
        }
        
        sum = 0;
        int []row = new int[n];
        getAnswer(0, row);
        return sum;
    }
    
    private boolean isValid(int curRow, int curCol, int []row)
    {
        boolean ret = true;
        for(int i = 0; i < curRow; i++)
        {
            if(row[i]==curCol)
            {
                ret = false;
                break;
            }
            
            if(curRow - i == Math.abs(curCol - row[i]))
            {
                ret = false;
                break;
            }
        }
        return ret;
    }
    
    
    private void getAnswer(int curRow, int []row)
    {
        int n = row.length;
        if(curRow >= n)
        {
            sum++;
            return;
        }
        
        for(int i = 0; i < n; i++)
        {
            if(isValid(curRow, i, row))
            {
                row[curRow] = i;
                getAnswer(curRow + 1, row);
            }
        }
    }
}