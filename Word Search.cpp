class Solution {
public:
    bool exist(vector<vector<char> > &board, string word) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        
        if(word.empty())
            return false;
        
        int M = board.size();
        int N = board[0].size();
        bool flag = false;
        for(int i = 0; i < M; i++)
        {
            for(int j = 0; j < N; j++)
            {
                flag = search(board, word, 0, i, j);
                if(flag)
                    return true;
            }
        }
        
        return flag;
    }
    
    /* for the search problem, checking boundery return false. 
    However when we do those things, make sure when we find the right result, return immediately!!!
    for this question, if I put things like:
        if(j<0||j>=N||i<0||i>=M)
            return false;
        
        if(board[i][j]!=word[index])
            return false;
        
        
        //bool flag = false;
        
       if(index==word.size())
            return true;
    even I get the right result, still I will get false!!!!!!!!!!!!!!!!!!!!!
    
    */
    
    bool search(vector<vector<char> > &board, string &word, int index, int i, int j)
    {
        int M = board.size();
        int N = board[0].size();
        
        if(j<0||j>=N||i<0||i>=M)
            return false;
        
        if(board[i][j]!=word[index])
            return false;
        
        
        //bool flag = false;
        
       if(index==word.size()-1)
            return true;
        
        char originalValue = board[i][j];
        board[i][j] = '#';
        bool flag = search(board, word, index + 1, i-1, j);
        if(flag)
        {
            board[i][j] = originalValue;
            return true;
        }
        
        flag = search(board, word, index + 1, i+1, j);
        if(flag)
        {
            board[i][j] = originalValue;
            return true;
        }
        
        flag = search(board, word, index + 1, i, j-1);
        if(flag)
        {
            board[i][j] = originalValue;
            return true;
        }
        
        flag = search(board, word, index + 1, i, j+1);
        board[i][j] = originalValue;
        
        return flag;
        
    }
    
    
    
};