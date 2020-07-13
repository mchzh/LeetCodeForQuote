class Solution {
    // https://leetcode.com/problems/surrounded-regions/discuss/167165/Java-Union-Find-with-Explanations
    // https://leetcode.com/problems/surrounded-regions/discuss/691602/Java-1ms-Simple
    // https://leetcode.com/problems/surrounded-regions/solution/
    public void solve(char[][] board) {
        // corner case
        if (board == null || board.length == 0 || board[0].length == 0) return;
        // union find + bfs + dfs
        // top row and bottom row
        // from the 'O' of boundary to start
        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[board.length-1][j] == 'O') {
                dfs(board, board.length-1, j);
            }
        }
        for (int i = 1; i < board.length-1; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][board[0].length-1] == 'O') {
                dfs(board, i, board[0].length-1);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '#') board[i][j] = 'O'; // non-surrooudned regions
            }
        }
    }
    private void dfs(char[][] board, int x, int y) {
        
        board[x][y] = '#';
        int[] dirs = {0, -1, 0, 1, 0};
        for (int k = 0; k < dirs.length-1; k++) {
            int cx = x + dirs[k];
            int cy = y + dirs[k+1];
            if (cx >= 0 && cx < board.length && cy >= 0 && cy < board[0].length && board[cx][cy] == 'O') {
                dfs(board, cx, cy);
            }
        }
    }
}
