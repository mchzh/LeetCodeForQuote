class Solution {
    public int maxProductPath(int[][] grid) {
        long mod = (long)1e9+7;
        int m = grid.length, n = grid[0].length;
        long[][][] dp = new long[m][n][2];
        dp[0][0][0] = grid[0][0];
        dp[0][0][1] = grid[0][0];
        // first row
        for (int j = 1; j < n; j++) {
            dp[0][j][0] = (dp[0][j-1][0]*grid[0][j]);
            dp[0][j][1] = (dp[0][j-1][1]*grid[0][j]);
        }
        // first col
        for (int i = 1; i < m; i++) {
            dp[i][0][0] = (dp[i-1][0][0]*grid[i][0]);
            dp[i][0][1] = (dp[i-1][0][1]*grid[i][0]);
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long p1 = (dp[i-1][j][0] * grid[i][j]);
                long p2 = (dp[i-1][j][1] * grid[i][j]);
                long p3 = (dp[i][j-1][0] * grid[i][j]);
                long p4 = (dp[i][j-1][1] * grid[i][j]);
                
                dp[i][j][0] = Math.max(Math.max(p1, p2), Math.max(p3, p4));
                dp[i][j][1] = Math.min(Math.min(p1, p2), Math.min(p3, p4));
            }
        }
        if (dp[m-1][n-1][0] < 0) return -1;
        else return (int)(dp[m-1][n-1][0]%mod);
    }
}


// 1d dp array

// X X  X X
// Y Y] Y Y

// dp1[i,j] = max(dp1[i-1,j]*g[i][j], dp1[i,j-1]*g[i][j], dp2[i-1,j]*g[i][j], dp2[i,j-1]*g[i][j]);
// dp2[i,j] = min(dp1[i-1,j]*g[i][j], dp1[i,j-1]*g[i][j], dp2[i-1,j]*g[i][j], dp2[i,j-1]*g[i][j]);
