class Solution {
    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    public boolean placeWordInCrossword(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                //System.out.println(i + " : " + j + " : " + c);
                if (c != word.charAt(0) && c != ' ') continue;
                //System.out.println("start -> " + i + " : " + j);
                for (int k = 0; k < 4; k++) {
                    // previous point
                    int x = i - dirs[k][0];
                    int y = j - dirs[k][1];
                    if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] != '#') continue;
                    //System.out.println("directio true -> " + k + " : " + i + " : " + j + " : " + isMatch(board, i, j, k, word));
                    if (isMatch(board, i, j, k, word)) return true;
                }
            }
        }
        return false;
    }
    private boolean isMatch(char[][] board, int i, int j, int k, String word) {
        int m = board.length, n = board[0].length;
        int size = word.length();
        for (int t = 0; t < size; t++) {
            int x = i + dirs[k][0]*t;
            int y = j + dirs[k][1] * t;
            if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] == '#') return false;
            char c = word.charAt(t);
            if (board[x][y] != ' ' && board[x][y] != c) return false;
        }
        // next step after matching
        int t = size;
        int x = i + dirs[k][0]*t;
        int y = j + dirs[k][1] * t;
        if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] != '#') return false;
        return true;
    }
}

// start point:
// 1. stand by boundary or "#";
// 2. equals word[0] or empty ' '
// 3. search direction must be oppsite from boundary or "#"

// match requirement:
// 1. match the word allow ' '
// 2. after matching, move forward one step and be in boundary or "#"
