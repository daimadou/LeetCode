public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String[]> ret = new ArrayList<String[]>();
        if(n == 0)
        {
            return ret;
        }
        
        String[] board = new String[n];
        int []row = new int[n];
        getAnswer(0, board, row, ret);
        return ret;
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
    
    
    private void getAnswer(int curRow, String[]board, int []row, ArrayList<String[]> ret)
    {
        int n = row.length;
        if(curRow >= n)
        {
            String []answer = Arrays.copyOf(board, board.length);
            ret.add(answer);
            return;
        }
        
        char []line = new char[n];
        Arrays.fill(line, '.');
        for(int i = 0; i < n; i++)
        {
            if(isValid(curRow, i, row))
            {
                line[i] = 'Q';
                board[curRow] = new String(line);
                row[curRow] = i;
                getAnswer(curRow + 1, board, row, ret);
                line[i] = '.';
            }
        }
    }
    
}