class Solution {
    public int kInversePairs(int n, int k) {
        long[][] dp = new long[n+1][k+1];
        long M = (long)(1e9+7);
        for (int i = 0; i < n+1; i++) dp[i][0] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j >= i) {
                    dp[i][j] = (dp[i][j-1] + dp[i-1][j-0] - dp[i-1][j-i] + M) % M;
                } else {
                    dp[i][j] = (dp[i][j-1] + dp[i-1][j-0]) % M;
                }
            }
        }
        
        return (int)dp[n][k];
    }
}
// dp[i][j]: i number and k inverse pair

// [1,2,3,4,5] 6
// [6, x,x,x,x,x]
// ....
// [x,x,x,x,x,6]
// dp[6][j] += dp[5][j-5] + dp[5][j-4] + .... + dp[5][j]

// dp[i][j] = sum(dp[i-1][j-m]) m = 0, 1,....., i-1
// dp[i][j] = dp[i-1][j-0] + dp[i-1][j-1] + dp[i-1][j-2] + .... + dp[i-1][j-(i-2)] + dp[i-1][j-(i-1)];
// dp[i][j-1] = dp[i-1][j-1] + dp[i-1][j-2] + dp[i-1][j-3] + .... + dp[i-1][j-1-(i-2)] + dp[i-1][j-(i)];
// dp[i][j] - dp[i][j-1] = dp[i-1][j-0] - dp[i-1][j-(i)];
// dp[i][j] = dp[i][j-1] + dp[i-1][j-0] - dp[i-1][j-i];
