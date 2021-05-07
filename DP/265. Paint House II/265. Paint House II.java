class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length, k = costs[0].length;
        int[][] dp = new int[n][k];
        int fmin = Integer.MAX_VALUE, smin = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            dp[0][j] = costs[0][j];
            if (dp[0][j] < fmin) {
                smin = fmin;
                fmin = dp[0][j];
            } else if (dp[0][j] < smin) {
                smin = dp[0][j];
            }
        }
        
        for (int i = 1; i < n; i++) {
            int oldfmin = fmin;
            int oldsmin = smin;
            fmin = Integer.MAX_VALUE;
            smin = Integer.MAX_VALUE;
            //System.out.println(oldfmin + " " + oldsmin);
            for (int j = 0; j < k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                // min and second min
                if (dp[i-1][j] == oldfmin) {
                    dp[i][j] = Math.min(dp[i][j], oldsmin + costs[i][j]);
                } else {
                    dp[i][j] = Math.min(dp[i][j], oldfmin + costs[i][j]);
                }
                //System.out.println(dp[i][j]);
                //dp[i][j] = Math.min(dp[i][j], dp[i-1][s] + costs[i][j]);
                // for (int s = 0; s < k; s++) {
                //     if (s == j) continue;
                //     dp[i][j] = Math.min(dp[i][j], dp[i-1][s] + costs[i][j]);
                // }
                if (dp[i][j] < fmin) {
                    smin = fmin;
                    fmin = dp[i][j];
                } else if (dp[i][j] < smin) {
                    smin = dp[i][j];
                }
            }
        }
        int rets = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            rets = Math.min(rets, dp[n-1][j]);
        }
        return rets;
    }
}

// dp[i][j]: the minimum cost to paint ith house with j color
// dp[i][j] = min(dp[i-1][k])  s = 0....k, s != j
