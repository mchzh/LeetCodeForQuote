class Solution {
    // dp
    // same question: 1262. Greatest Sum Divisible by Three
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        long[][][] dp = new long[m][n][k];
        long mod = (long)1e9+7;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += grid[i][0];
            dp[i][0][sum%k] = 1;
        }
        sum = 0;
        for (int j = 0; j < n; j++) {
            sum += grid[0][j];
            dp[0][j][sum%k] = 1;
        }
        // dp[0][0][grid[0][0]%k] = 1;
        // System.out.println(dp[0][0][grid[0][0]%k]);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int cur = grid[i][j]%k;
                for (int r = 0; r < k; r++) {
                    dp[i][j][r] = dp[i][j-1][(r-cur+k)%k] + dp[i-1][j][(r-cur+k)%k];
                    dp[i][j][r] %= mod;
                }
            }
        }
        return (int)dp[m-1][n-1][0];
    }
}

//dp[i][j][r]: end with [i, j] point and sum (includes matrix[i][j]) divide by k remider is r
// path must select current point, not exists non-selection situation
// matrix[i][j] % k = s
// dp[i][j][r] = Math.max(dp[i-1][j][(r-s+k)%k], dp[i][j-1][(r-s+k)%k]) + matrix[i][j]
// (s+x)%k = r;
// (r-s+k)%k
// for (int i = 0; i < m; i++) {
//     for (int j = 0; j < n; j++) {
//         s = matrix[i][j]%k;
//         for (int r = 0; r < k; r++) {
//             dp[i][j][r] = dp[i-1][j][t] + dp[i][j-1][t]
//         }
//     }
// }
// r = (t+grid[i][j])%k
// return dp[i][j][0]
// initiliaze value 
