class Solution {
    // dfs template
    public void solveSudoku(char[][] board) {
        dfs(board, 0, 0);
    }
    private boolean dfs(char[][] board, int x, int y) {
        if (x == 9) return true;
        if (y == 9) return dfs(board, x+1, 0);
        
        if (board[x][y] != '.') return dfs(board, x, y+1);
        
        for (char c = '1'; c <= '9'; c++) {
            if (!isValid(board, x, y, c)) continue;
            board[x][y] = c;
            if (dfs(board, x, y+1)) return true;
            board[x][y] = '.';
        }
        
        return false;
    }
    private boolean isValid(char[][] board, int i, int j, char c) {
        for (int col = 0; col < 9; col++) {
            if (board[i][col] == c) return false;
        }
        for (int row = 0; row < 9; row++) {
            if (board[row][j] == c) return false;
        }
        int top = i/3 *3;
        int left = j/3 * 3;
        for (int t = 0; t < 3; t++) {
            for (int l = 0; l < 3; l++) {
                if (board[top+t][left+l] == c) return false;
            }
            
        }
        return true;
    }
}
