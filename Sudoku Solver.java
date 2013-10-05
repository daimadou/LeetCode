public class Solution {
    boolean [][][]blockRecords;
    boolean [][]rowRecords;
    boolean [][]colRecords;
    ArrayList<Integer> emptySpots;
    final int rowNum = 9;
    final int colNum = 9;
    public void solveSudoku(char[][] board) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        initialRecords();
        parseBoard(board);
        _solveSudoku(0, board);
    }
    
    private void initialRecords()
    {
        blockRecords = new boolean[3][3][9];
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j <3; j++)
            {
                Arrays.fill(blockRecords[i][j], false);
            }
        }
        rowRecords = new boolean[9][9];
        for(int i = 0; i < 9; i++)
        {
             Arrays.fill(rowRecords[i], false);
        }
        colRecords = new boolean[9][9];
        for(int i = 0; i < 9; i++)
        {
             Arrays.fill(colRecords[i], false);
        }
        emptySpots = new ArrayList<Integer>();
    }

    private void parseBoard(char[][] board)
    {
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(board[i][j] != '.')
                {
                    int num = board[i][j] - '0';
                    setRecords(i, j, num, true);
                }
                else
                {
                    emptySpots.add(j+i*rowNum);
                }
            }
        }
    }
    
    private boolean isValid(int i, int j, int num)
    {
        return !blockRecords[i/3][j/3][num-1]&&!rowRecords[i][num-1]&&!colRecords[j][num-1];
    }
    
    private void setRecords(int i, int j, int num, boolean val)
    {
        blockRecords[i/3][j/3][num - 1] = val;
        rowRecords[i][num - 1] = val;
        colRecords[j][num - 1] = val;
    }
    
    private boolean _solveSudoku(int index, char[][] board)
    {
        if(index==emptySpots.size())
        {
            return true;
        }
        
        int i = emptySpots.get(index) / rowNum;
        int j = emptySpots.get(index) % rowNum;
        boolean ret = false;
        for(int num = 1; num <=9; num++)
        {
            if(isValid(i, j, num))
            {
                 setRecords(i, j, num, true);
                 if(_solveSudoku(index + 1, board))
                 {
                     board[i][j] = (char)(num + '0');
                     ret = true;
                     break;
                 }
                 setRecords(i, j, num, false);
            }
        }
        return ret;
    }
}