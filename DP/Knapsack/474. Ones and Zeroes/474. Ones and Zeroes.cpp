class Solution {
public:
    int findMaxForm(vector<string>& strs, int m, int n) {
        auto dp = vector<vector<int>>(m+1, vector<int>(n+1, 0));
        // initilized value
        
        for (int k = 0; k < strs.size(); k++) {
            int ones = 0, zeros = 0;
            for (auto x : strs[k]) {
                if (x == '1') ones++;
                else zeros++;
            }
            
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = max(dp[i][j], dp[i-zeros][j-ones] + 1);
                }
            }
        }
        return dp[m][n];
    }
};
