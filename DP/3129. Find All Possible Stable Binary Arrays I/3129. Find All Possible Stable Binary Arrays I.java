class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        long mod = (long)(1e9+7);
        long[][][] dp = new long[zero+1][one+1][2];
        // dp[0][0]: non zero and one no valid array
        // initial
        for (int i = 1; i <= Math.min(zero,limit); i++) {
            dp[i][0][0] = 1;
        }
        for (int i = 1; i <=  Math.min(one,limit); i++) {
            dp[0][i][1] = 1;
        }
        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                dp[i][j][0] = (dp[i-1][j][0] + dp[i-1][j][1]) % mod;
                if (i-limit-1 >= 0) {
                    dp[i][j][0] = (dp[i][j][0] - dp[i-limit-1][j][1] + mod) % mod;
                }
                dp[i][j][1] = (dp[i][j-1][0] + dp[i][j-1][1]) % mod;
                if (j-limit-1 >= 0) {
                    dp[i][j][1] = (dp[i][j][1] - dp[i][j-limit-1][0] + mod) % mod;
                }
            }
        }
        return (int)((dp[zero][one][0] + dp[zero][one][1])%mod);
    }
}
// X X X X 0,....
// dp[m][n][0]: m zero and n one with end 0
// return dp[zero][one][0] + dp[zero][one][1]
// for i zero and j one
// end with 0: dp[i][j][0] = dp[i-1][j][0] + dp[i-1][j][1];
// invalid case is : dp[i-limit-1][j][1]
