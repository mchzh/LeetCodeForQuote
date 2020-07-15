class Solution {
    public double probabilityOfHeads(double[] prob, int target) {
        int N = prob.length;
        double[][] dp = new double[N+1][target+1];
        dp[0][0] = 1.0;
        
        for (int i = 1; i <= N; i++) {
            dp[i][0] = dp[i-1][0]*(1-prob[i-1]);
        }
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i-1][j-1] * prob[i-1] + dp[i-1][j]*(1-prob[i-1]);
            }
        }
        return dp[N][target];
    }
}

// dp[][] : where pos represents the pos-th coin and cnt is the number of heads seen so far.
// xxxxxx i (prob/pos) select [i-1][j-1]*prob
// yyyy j (num) [i-1][j] * (1-proj)
