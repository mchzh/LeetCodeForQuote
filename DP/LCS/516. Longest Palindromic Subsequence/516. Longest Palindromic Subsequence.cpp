class Solution {
public:
    int longestPalindromeSubseq(string s) {
        int N = s.size();
        s = "#" + s;
        auto dp = vector<vector<int>>(N+1, vector<int>(N+1, 0));
        
        for (int i = 1; i <= N; i++) {
            dp[i][i] = 1;
        }
        
        for (int len = 2; len <= N; len++) {
            for (int i = 1; i <= N-len+1; i++) {
                int j = i+len-1;
                if (s[i] == s[j]) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[1][N];
    }
};

// X X X j X X i
// dp[i][j] = dp[i+1][j-1] + 2;
