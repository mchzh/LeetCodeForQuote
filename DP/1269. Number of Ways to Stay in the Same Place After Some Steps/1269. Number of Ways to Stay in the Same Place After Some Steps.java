class Solution {
    // dp[i][j] = dp[i-1][j-1] + dp[i-1][j] + dp[i-1][j+1];
    public int numWays(int steps, int arrLen) {
        //if(arrLen > steps + 1) arrLen = steps + 1;
        //arrLen = steps/2 + 3;
        // i : 0 steps
        // j : 0 -> len
        int len = steps/2+2;
        long mod = (long)(1e9+7);
        long[] dp = new long[len];
        dp[0] = 1;
        for (int i = 1; i <= steps; i++) {
            long[] old_dp = Arrays.copyOf(dp, len);
            Arrays.fill(dp, 0);
            for (int j = 0; j < Math.min(arrLen, steps/2 + 2); j++) {
                if (j > 0) dp[j] += old_dp[j-1];
                if (j < Math.min(arrLen, steps/2 + 2)-1) dp[j] += old_dp[j+1];
                dp[j] += old_dp[j];
                dp[j] %= mod;
            }
        }
        return (int)dp[0];
    }
}
