public class Solution {
    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(board.length == 0 || board[0].length == 0) return;
        Queue<Integer> q = new LinkedList<Integer>();
        int iLen = board.length;
        int jLen = board[0].length;
        for(int j = 0; j < jLen; j++)
        {
            if(board[0][j]=='O')
            {
                q.offer(j);
                board[0][j]='+';
            }
            if(board[iLen-1][j]=='O')
            {
                q.offer((iLen-1)*jLen+j);
                board[iLen-1][j]='+';
            }
        }
        for(int i = 1; i < iLen-1; i++)
        {
            if(board[i][0]=='O')
            {
                q.offer(i*jLen);
                board[i][0]='+';
            }
            if(board[i][jLen-1]=='O')
            {
                q.offer(i*jLen+jLen-1);
                board[i][jLen-1]='+';
            }
        }
        
        
        while(!q.isEmpty())
        {
            int cur = q.poll();
            int t = cur / board[0].length;
            int s = cur % board[0].length;
            visit(t - 1, s, q, board);
            visit(t, s - 1, q, board);
            visit(t + 1, s, q, board);
            visit(t, s + 1, q, board);
        }
        
        for(int i = 0; i < iLen; i++)
        {
            for(int j = 0; j < jLen; j++)
            {
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == '+') board[i][j] = 'O';
            }
        }
    }
    
    private void visit(int i, int j, Queue<Integer> q, char[][] board)
    {
        int m = board.length, n = board[0].length;
        if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') return;
        board[i][j] = '+';
        q.offer(i * n + j);
    }
}
