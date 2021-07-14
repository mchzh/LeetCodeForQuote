class Solution {
public:
    string minWindow(string s1, string s2) {
        int m = s1.size(), n = s2.size();
        s1 = "#" + s1;
        s2 = "#" + s2;
        
        vector<vector<int>>dp(m+1, vector<int>(n+1, INT_MAX/2));
        // init
        dp[0][0] = 0;
        for (int j = 1; j <= n; j++) dp[0][j] = INT_MAX/2;
        for (int i = 1; i <= m; i++) dp[i][0] = 0;
        
        for (int i =1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1[i] == s2[j]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = dp[i-1][j] + 1;
                }
            }
        }
        
        // do not know where ending 1----i
        int len = INT_MAX/2;
        int pos = -1;
        for (int i = 1; i <= m; i++) {
            if (dp[i][n] < len) {
                len = dp[i][n];
                pos = i;
            }
        }
        
        if (len >= INT_MAX/2) return "";
        else return s1.substr(pos-len+1, len);
    }
};

// dp[i][j]: ending with S[i]
// XXXXX i
// YYY j
// dp[i][j] = dp[i-1][j-1] + 1; si = tj
// dp[i][j] = dp[i-1][j] + 1; si != tj
