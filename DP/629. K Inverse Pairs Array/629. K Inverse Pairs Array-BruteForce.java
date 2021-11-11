class Solution {
    // dp without optimized
    public int kInversePairs(int n, int k) {
        long[][] dp = new long[n+1][k+1];
        long mod = (long)(1e9+7);

        for (int i = 0; i <= n; i++) dp[i][0] = 1;  // motholic increasing sequence

        for (int i = 1; i <= n; i++) {
            for (int j =1; j <= k; j++) {
                for (int m = 0; m <= Math.min(i-1, j); m++) {
                    dp[i][j] += dp[i-1][j-m];
                    dp[i][j] %= mod;
                }
            }
        }

        return (int)dp[n][k];
    }
}

// dp[i][j]: all permutation of the i number with j paire inverse 
// [1,2,3,4,5] 6

// 6 [X X X X X] i = 6, j
// [6, X X X X X] [5, j-5]
// [X 6 X X X X] [5, j-4]
// ......
// [X X X X X 6] [5, j] (add 6 not generate new inverse pair)

// dp[i][j] = sum( dp[i-1][j-k] ) {k = 0, 1, 2, 3, 4, ...., i-1}
