class Solution {
public:
    int longestArithSeqLength(vector<int>& A) {
        int n = A.size();
        int dp[n][1001];
        std::memset(dp, 0, sizeof dp);
        
        int rets = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = A[i] - A[j] + 500;
                if (dp[j][diff] == 0) dp[j][diff] = 1;
                dp[i][diff] = max(dp[i][diff], dp[j][diff]+1);
                rets = max(rets, dp[i][diff]);
            }
        }
        return rets;
    }
};
