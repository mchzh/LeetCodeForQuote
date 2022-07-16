class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        long mod = (long)(1e9+7);
        long[][] dp = new long[m][n];
        long[][] dataDp = Arrays.stream(dp)
             .map((long[] row) -> row.clone())
             .toArray((int length) -> new long[length][]);
        
        for (int k = 0; k < maxMove; k++) {
            
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // four direction
                    // dp[i][j] need to recaculate
                    dp[i][j] = 0;
                    dp[i][j] += (i-1< 0 ? 1 : dataDp[i-1][j]);
                    dp[i][j] += (j+1>= n ? 1 : dataDp[i][j+1]);
                    dp[i][j] += (i+1>= m ? 1 : dataDp[i+1][j]);
                    dp[i][j] += (j-1< 0 ? 1 : dataDp[i][j-1]);
                    dp[i][j] %= mod;
                }
            }
            
            dataDp = Arrays.stream(dp)
             .map((long[] row) -> row.clone())
             .toArray((int length) -> new long[length][]);
        }
        
        return (int)dp[startRow][startColumn];
    }
}
// revert thinking: from out of boundary point to grid
// k-1 -> k

// 1 0
// 0 0
    
// 1 1
// 1 0
    
// 2 1
// 1 2
    
//     x x
//   x 2 1 x
//   x 1 2 x
//     x x
