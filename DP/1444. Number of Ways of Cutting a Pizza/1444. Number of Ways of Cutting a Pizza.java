class Solution {
    // https://www.acwing.com/file_system/file/content/whole/index/content/524417/
    public int ways(String[] pizza, int k) {
        long mod = (long)(1e9+7);
        int m = pizza.length, n = pizza[0].length();
        int[][] presum = new int[m+1][n+1];
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                presum[i][j] = presum[i+1][j] + presum[i][j+1] - presum[i+1][j+1] + ((pizza[i].charAt(j) == 'A') ? 1 : 0);
                //System.out.println(i + " " + j + " " + presum[i][j]);
            }
        }
        
        long[][][] dp = new long[m][n][k];
        // initialize
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                dp[i][j][0] = (presum[i][j] > 0) ? 1 : 0;
        
        for (int l = 1; l < k; l++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // vertical
                    for (int t = i+1; t < m; t++) {
                        if (check(i, j, t-1, n-1, presum)) dp[i][j][l] = (dp[i][j][l] + dp[t][j][l-1])%mod;
                    }
                    // horizatal
                    for (int t = j+1; t < n; t++) {
                        if (check(i, j, m-1, t-1, presum)) dp[i][j][l] = (dp[i][j][l] + dp[i][t][l-1])%mod;
                    }
                }
            }
        }
        
        return (int)dp[0][0][k-1];
    }
    private boolean check(int x1, int y1, int x2, int y2, int[][] presum) {
        return presum[x1][y1] - presum[x2+1][y1] - presum[x1][y2+1] + presum[x2+1][y2+1] > 0;
    }
}

// X X X X X X X X X
// [X X X X] i
// dp[row1][col1][c]: the number of ways of cutting the pizza with c cuts where the current of pizza has upper left coordinate at (rows, cols) and lower right coordinate at (rows-1, cols-1)
// from right corner move to left top
// presum to get the apple number from [i, j] to [r-1, c-1]
// int[][] presum = new int[r+1][c+1];
// for (int i = r-1; i >= 0; i--) {
//     for (int j = c-1; j >= 0; j--) {
//         presum[i][j] = presum[i+1][j] + presum[i][j+1] - presum[i+1][j+1];
//     }
// }

// for r: i -- r-1 t from i+1 to r-1
// vertically: ti -> [i, j] to [ti-1, c-1] and [ti,j] to [r-1, c-1]
// dp[i][j][k] = dp[i][j][k] + sum{dp[t][j][k-1]};
// for c: j -- c-1 t from j+1 to c-1
// horizally: tj -> [i, j] to [r-1, tj-1] and [i,tj] to [r-1, c-1]
// dp[i][j][k] = dp[i][j][k] + sum{dp[i][t][k-1]};
