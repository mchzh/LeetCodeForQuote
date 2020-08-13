class Solution {
    public int countSquares(int[][] matrix) {
        int M = matrix.length, N = matrix[0].length;
        int[][] dp = new int[M][N];
        int count = 0;
        for (int i = 0; i < M ;i++) {
            if (matrix[i][0] == 0) continue;
            dp[i][0] = 1;
            count += 1;
        }
        
        for (int i = 1; i < N ;i++) {
            if (matrix[0][i] == 0) continue;
            dp[0][i] = 1;
            count += 1;
        }
        
        
        for (int i = 1; i < M ;i++) {
            for (int j = 1; j < N; j++) {
                if (matrix[i][j] == 0) continue;
                dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                count += dp[i][j]; 
            }
        }
        return count;
    }
}

// matrix[][] = 1;
// dp[][] = min(dp[i-1][j-1], dp[i][j-1], dp[i-1][j]) + 1;
