class Solution {
public:
    int kInversePairs(int n, int k) {
        vector<vector<long>>dp(n+1, vector<long>(k+1, 0));
        int mod = 1e9+7;

        for (int i = 0; i <= n; i++) dp[i][0] = 1;  // motholic increasing sequence

        for (int i = 1; i <= n; i++) {
            for (int j =1; j <= k; j++) {
                if (j >= i) dp[i][j]= ((dp[i-1][j] + dp[i][j-1] - dp[i-1][j-i])+mod) % mod;
                else dp[i][j] = dp[i-1][j] + dp[i][j-1];
                dp[i][j] %= mod;
            }
        }

        return dp[n][k];
    }
};
