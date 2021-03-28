class Solution {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        
        int[] dp = new int[n+1];
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            for (int j = 2; j <= i/2; j++) {
                dp[i] = Math.max(dp[i], dp[j]*dp[i-j]);
            }
        }
        return dp[n];
    }
}

// dp
// d = i + j
//    (x1+x2+x3) + (X4+X5)
// M => M/2 * M/2
// M => M/n => pow(M/n, n) M/n~~ e = 2.73
