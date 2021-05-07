class Solution {
    public int minFallingPathSum(int[][] arr) {
        int n = arr.length, k = arr[0].length;
        int[][] dp = new int[n][k];
        int fmin = Integer.MAX_VALUE, smin = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            dp[0][j] = arr[0][j];
            if (dp[0][j] < fmin) {
                smin = fmin;
                fmin = dp[0][j];
            } else if (dp[0][j] < smin) {
                smin = dp[0][j];
            }
        }
        
        for (int i = 1; i < n; i++) {
            int oldfmin = fmin, oldsmin = smin;
            fmin = Integer.MAX_VALUE;
            smin = Integer.MAX_VALUE;
            
            for (int j = 0; j < k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                if (dp[i-1][j] == oldfmin) {
                    dp[i][j] = Math.min(dp[i][j], oldsmin+arr[i][j]);
                } else {
                    dp[i][j] = Math.min(dp[i][j], oldfmin+arr[i][j]);
                }
                
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
