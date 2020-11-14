class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        s = "#" + s;
        t = "#" + t;
        
        for (int i = 0; i <= n; i++) dp[i][0] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] += dp[i-1][j];
                if (s.charAt(i) == t.charAt(j)) dp[i][j] += dp[i-1][j-1];
            }
        }
        return dp[n][m];
    }
}

// dp[i][j] : the number of distinct subsequences of s[1...i] which equals t[1...j]
// dp[i-1][j-1]
// dp[i-1][j]
// dp[i][j-1]

// X X X X X X a
// Y Y Y Y a
// dp[i-1][j-1]
// dp[i-1][j]
