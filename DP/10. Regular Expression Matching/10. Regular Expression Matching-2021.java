class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        s = "#" + s;
        p = "#" + p;
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int x = 2; x <= n; x++) {
            dp[0][x] = p.charAt(x) == '*' && dp[0][x-2];
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j) == '.') dp[i][j] = dp[i-1][j-1];
                else if (p.charAt(j) == '*') {
                    boolean possible1 = (j-2 >= 0) && dp[i][j-2];
                    boolean possible2 = (s.charAt(i) == p.charAt(j-1) || p.charAt(j-1) == '.') && dp[i-1][j];
                    dp[i][j] = possible1 || possible2;
                } else {
                    dp[i][j] = (s.charAt(i) == p.charAt(j)) && dp[i-1][j-1];
                }
            }
        }
        return dp[m][n];
    }
}

// dp[0][j]:
// s:
// t: Y * Y * Y *


// s: X X X X X Z
// t: Y Y Y Z *
