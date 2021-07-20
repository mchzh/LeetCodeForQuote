class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        s = "#" + s;
        p = "#" + p;
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int x = 1; x <= n; x++) {
            if (p.charAt(x) != '*') break;
            dp[0][x]= true;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(j) == '*') {
                    // for (int k = 0; k <= i; k++) {
                    //     if (dp[k][j-1]) dp[i][j] = true;
                    // }
                    // * not user dp[i][j] = dp[i][j-1] or * use multiple times -> dp[i][j] = dp[i-1][j] (recursive idea)
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }
}

// XXXXX i
// YYYYYYY *
