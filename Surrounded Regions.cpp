class Solution {
public:
    void solve(vector<vector<char>> &board) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        
        if(board.empty())
            return;
        const int R = board.size();
        const int C = board[0].size();
        
        recordBound(board);
        for(int i=0; i<R; i++)
        {
            for(int j=0; j<C; j++)
                board[i][j] = board[i][j]=='#'?'O':'X';
        
        }
        
       
        
    }
    
    void recordBound(vector<vector<char>> &board)
    {
     
        const int R = board.size();
        const int C = board[0].size();
        
        for(int i=0; i<C; i++)
        {
            if(board[0][i]=='O')
                recordBound(board, 0, i, R, C);
            if(board[R-1][i]=='O')
                recordBound(board, R-1, i, R, C);
        }
        
        for(int i=1; i<R-1; i++)
        {
            if(board[i][0]=='O')
                recordBound(board, i, 0, R, C);
            if(board[i][C-1]=='O')
                recordBound(board, i, C-1, R, C);
        }
    }
    
    void recordBound(vector<vector<char>> &board, int row, int colum, const int R, const int C)
    {
        if(row<0||row==R||colum<0||colum==C)
            return;
        else  if(board[row][colum]=='X'||board[row][colum]=='#')
            return;
        else
        {
            board[row][colum] = '#';
            recordBound(board, row, colum+1, R, C);
            recordBound(board, row, colum-1, R, C);
            recordBound(board, row-1, colum, R, C);
            recordBound(board, row+1, colum, R, C);
        }
       
    }
};