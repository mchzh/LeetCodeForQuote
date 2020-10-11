class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        // dp : the edge len of max square at the current point
        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row][col];
        // initial
        // first row
        int max = 0;
        for (int i = 0; i < col; i++) {
            if (matrix[0][i] == '0') continue; 
            dp[0][i] = 1;
            max = 1;
        }
        // first column
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == '0') continue; 
            dp[i][0] = 1;
            max = 1;
        }
        
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                //System.out.println("before -> " + dp[i][j] + " : " + i + " : " + j + " : " + matrix[i][j]);
                if (matrix[i][j] == '0') continue;
                dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                //System.out.println(dp[i][j] + " : " + i + " : " + j + " : " + matrix[i][j]);
                max = Math.max(max, dp[i][j] * dp[i][j]);
            }
        }
        return max;
    }
}

// X X X| X| X X
// X X X| X] X X
// X X X  X X X

// dp[i][j] = grid[i][j] == 0 ? 0 : min([i-1, j], [i, j-1], [i-1, j-1])+1;

/*class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int [] [] dp = new int[rows + 1] [cols + 1];
        int maxsqlen = 0;
        
        for(int i = 1; i<= rows; i++) {
            for(int j = 1; j <= cols; j++) {
                if(matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j-1],dp[i-1][j]), dp[i-1][j-1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen ;
    }
}*/
