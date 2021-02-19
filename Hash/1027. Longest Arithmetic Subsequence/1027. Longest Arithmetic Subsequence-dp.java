class Solution {
    public int longestArithSeqLength(int[] A) {
        if (A== null || A.length == 0) return 0;
        int n = A.length;
        int[][] dp = new int[n][1001];
        
        int rets = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = A[i] - A[j] + 500;
                if (dp[j][diff] == 0) dp[j][diff] = 1;
                dp[i][diff] = Math.max(dp[i][diff], dp[j][diff]+1);
                rets = Math.max(rets, dp[i][diff]);
            }
        }
        return rets;
    }
}

//dp[i][diff]
