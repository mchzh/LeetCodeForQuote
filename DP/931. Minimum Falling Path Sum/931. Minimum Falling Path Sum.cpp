class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& A) {
        int m = A.size();
        int n = A[0].size();
        
        auto dp = A;
        // first step 
        for (int j = 0; j < n; j++) {
            dp[0][j] = A[0][j];
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = dp[i-1][j];
                if (j > 0) dp[i][j] = min(dp[i][j], dp[i-1][j-1]);
                if (j < n-1 ) dp[i][j] = min(dp[i][j], dp[i-1][j+1]);
                dp[i][j] += A[i][j];
            }
        }
        
        // last step 
        int ret = INT_MAX;
        for (int j = 0; j < n; j++) {
            ret = min(ret, dp[m-1][j]);
        }
        return ret;
    }
};

//dp[i][j] -> the minimum sum of a falling path from 0 row to {i, j}
//dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i-1][j+1]) + a[i][j]
