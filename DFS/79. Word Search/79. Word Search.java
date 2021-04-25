class Solution {
    // dfs + backtracking
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int pos, int x, int y) {
        if (pos == word.length()) return true;
        if (x < 0 || x >= board.length) return false;
        if (y < 0 || y >= board[0].length) return false;
        if (board[x][y] == '#') return false;
        
        char c = word.charAt(pos);
        if (board[x][y] != c) return false;
        board[x][y] = '#';
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int k = 0; k < 4; k++) {
            int cx = x + dirs[k][0];
            int cy = y + dirs[k][1];
            if (dfs(board, word, pos+1, cx, cy)) return true;
        }
        board[x][y] = c;
        return false;
    }
}
