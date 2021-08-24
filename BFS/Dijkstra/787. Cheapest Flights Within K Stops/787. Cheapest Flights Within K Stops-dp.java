class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] dp = new int[K+2][n];
        for (int[] d : dp) {
            Arrays.fill(d, Integer.MAX_VALUE/2);
        }

        dp[0][src] = 0;
        for (int i = 1; i <= K+1; i++) {
            for (int[] f : flights) {
                dp[i][f[1]] = Math.min(dp[i][f[1]], dp[i-1][f[0]] + f[2]);
                dp[i][f[1]] = Math.min(dp[i][f[1]], dp[i-1][f[1]]);
            }
        }

        // int rets = Integer.MAX_VALUE/2;
        // for (int i = 0; i <= K+1; i++) rets = Math.min(rets, dp[i][dst]);
        int rets = dp[K+1][dst];
        return rets >= Integer.MAX_VALUE/2 ? -1 : rets;
    }
}

//dp[k][c]: min path up k reach c
