class Solution {
    public int mergeStones(int[] stones, int K) {
        int N = stones.length;
        if ( (N-1) %(K-1) != 0) return -1;
        
        int[][][] dp = new int[N][N][K+1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        int[] presum = new int[N+1];
        for (int i = 0; i < N; i++) {
            presum[i+1] = presum[i] + stones[i];
            dp[i][i][1] = 0;
        }
        
        for (int len = 2; len <= N; len++) {
            for (int i = 0; i+len-1 < N; i++) {
                int j = i+len-1;
                for (int k = 2; k <= K; k++) {
                    if (k > len) continue;
                    for (int m = i; m < j; m++) {
                        if (dp[i][m][1] == Integer.MAX_VALUE || dp[m+1][j][k-1] == Integer.MAX_VALUE) continue;
                        dp[i][j][k] = Math.min(dp[i][j][k], dp[i][m][1] + dp[m+1][j][k-1]);
                    }
                }
                if (dp[i][j][K] == Integer.MAX_VALUE) continue;
                if ( (j-i) % (K-1) != 0) continue;
                dp[i][j][1] = dp[i][j][K] + presum[j+1]-presum[i];
            }
        }
        if (dp[0][N-1][1] == Integer.MAX_VALUE) return -1;
        else return dp[0][N-1][1];
    }
}
// interval DP
// dp[0][n-1][K]: divide as : dp[0][m][1] + dp[m+1][n-1][K-1] , m [0, n-1]
// dp[i][j][k] = dp[i][m][k] + dp[m+1][j][k-1] + sum[i-j], i<=m<j (len >= 1) 
    
// N
// N - (K-1)
// N - (K-1) *2
