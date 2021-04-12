class Solution {
    long[][] dp = new long[1001][1001];
    long[][] presum = new long[1001][1001];
    long mod = (long)(1e9+7);
    public int numberOfSets(int n, int k) {
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
            presum[i][0] = i+1;
        }
        
        for (int i = 1; i < n; i++) {
            for (int t = 1; t <= Math.min(i, k); t++) {
                dp[i][t] = dp[i-1][t];
                // for (int j = 0; j < i; j++) { // improve to presum
                //     dp[i][t] += dp[j][t-1];
                // }
                dp[i][t] += presum[i-1][t-1];
                presum[i][t] = dp[i][t] + presum[i-1][t];
                presum[i][t]%=mod;
            }
        }
        return (int)(dp[n-1][k]%mod);
    }
}

// dp[i][k]: for the first i points, compose to k segments lines
// X X X X X X X X i
//               ___ dp[i-1][k-1]
//             _____ dp[i-2][k-1]
// dp[i][k] = sum{dp[j][k-1]}; j = 0,1,2,...i-1
// X X X X X X X X i
//               _*  dp[i-1][k]
              
// dp[i][k] = dp[i-1][k] + sum{dp[j][k]}
// presum[j][k] = sum{dp[j][k]}
// presum[j+1][k] = dp[j+1][k] + presum[j][k]
