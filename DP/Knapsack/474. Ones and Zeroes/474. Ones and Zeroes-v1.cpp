class Solution {
public:
    int findMaxForm(vector<string>& strs, int m, int n) {
        auto dp = vector<vector<int>>(m+1, vector<int>(n+1, 0));
        auto new_dp = dp;

        for (int k = 0; k < strs.size(); k++) {
            auto s = strs[k];
            int ones = 0, zeros = 0;
            for (auto c : s) {
                if (c == '1') ones +=1 ;
                else zeros += 1;
            }

            for (int i = zeros; i <= m; i++) {
                for (int j = ones; j <= n; j++) {
                    new_dp[i][j] = max(dp[i][j], dp[i-zeros][j-ones]+1);
                }
            }
            dp = new_dp;
        }
        return dp[m][n];
    }
};
