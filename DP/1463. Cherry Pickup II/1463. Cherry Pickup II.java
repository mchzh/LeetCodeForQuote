class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[n][n];
        
        // set defautl value
        for (int[] d : dp) {
            Arrays.fill(d, Integer.MIN_VALUE);
        }
        dp[0][n-1] = grid[0][0] + grid[0][n-1];
        
        for (int r = 1; r < m; r++) {
            int[][] old_dp = Arrays.stream(dp).map(int[]::clone).toArray(int[][]::new);
           
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int a = i-1; a<=i+1; a++) {
                        for (int b = j-1; b <= j+1; b++) {
                            if (a<0 || a>=n || b <0 || b >= n) continue;
                            
                            if (i != j) {
                                dp[i][j] = Math.max(dp[i][j], old_dp[a][b] + grid[r][i] + grid[r][j]);
                            } else {
                                dp[i][j] = Math.max(dp[i][j], old_dp[a][b] + grid[r][i]);
                            }
                        }
                    }
                }
            }
        }
        
        int rets = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rets = Math.max(rets, dp[i][j]);    
            }
        }
        return rets;
    }
}
// dp[i][j] : the maximum number of cherries collection using both robots one at i pos and another at j pos

// current row:
// dp[r][i][j] = max (dp[r-1][a][b]) + grid[r][i] + grid[r][j];
// dfs + memo
/*class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Integer[][][] dp = new Integer[m][n][n];
        return dfs(grid, m, n, 0, 0, n - 1, dp);
    }
    int dfs(int[][] grid, int m, int n, int r, int c1, int c2, Integer[][][] dp) {
        if (r == m) return 0; // Reach to bottom row
        if (dp[r][c1][c2] != null) return dp[r][c1][c2];
        int ans = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nc1 = c1 + i, nc2 = c2 + j;
                if (nc1 >= 0 && nc1 < n && nc2 >= 0 && nc2 < n) {
                    ans = Math.max(ans, dfs(grid, m, n, r + 1, nc1, nc2, dp));
                }
            }
        }
        int cherries = c1 == c2 ? grid[r][c1] : grid[r][c1] + grid[r][c2];
        return dp[r][c1][c2] = ans + cherries;
    }
}*/
