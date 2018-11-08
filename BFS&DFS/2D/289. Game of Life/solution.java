class Solution {
    public void gameOfLife(int[][] board) {
        if(board.length == 0) return;
        // 1 - 0
        // 0->1=2  1->0=3 0->0=0 1->1=1
        for(int i = 0; i < board.length; i ++)
            for(int j = 0; j < board[0].length; j ++)
            {
                int count = 0;
                if(help(board,i-1,j-1)) count ++;
                if(help(board,i,j-1)) count ++;
                if(help(board,i+1,j-1)) count ++;
                
                if(help(board,i-1,j)) count ++;
                if(help(board,i+1,j)) count ++;
                
                if(help(board,i-1,j+1)) count ++;
                if(help(board,i,j+1)) count ++;
                if(help(board,i+1,j+1)) count ++;
                if(board[i][j] == 1 && count < 2) board[i][j] = 3;
                if(board[i][j] == 1 && count > 3) board[i][j] = 3;
                if(board[i][j] == 0 && count == 3) board[i][j] = 2;
            }
        
        for(int i = 0; i < board.length; i ++)
            for(int j = 0; j < board[0].length; j ++)
                if(board[i][j] == 3) board[i][j] = 0;
                else if(board[i][j] == 2) board[i][j] = 1;
    }
    public boolean help(int[][] board, int i, int j)
    {
        if(i<0 || i>=board.length || j<0 || j>=board[0].length) return false;
        if(board[i][j] == 1 || board[i][j] == 3) return true; else return false;
    }
}
