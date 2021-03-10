class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        s = "#" + s;
        p = "#" + p;
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int j = 2; j <= n; j++) {
            dp[0][j] = (p.charAt(j) == '*') && dp[0][j-2];
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char a = s.charAt(i);
                char b = p.charAt(j);
                if (Character.isAlphabetic(b)) {
                    dp[i][j] = (a == b) && dp[i-1][j-1];
                } else if (b == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (b == '*') {
                    boolean pos1 = dp[i][j-2];
                    boolean pos2 = dp[i-1][j] && ((a==p.charAt(j-1)) || (p.charAt(j-1)=='.'));
                    dp[i][j] = pos1 || pos2;
                }
            }
        }
        return dp[m][n];
    }
}


// s: X X X X Z
// p: Y Y Z zzz ZZZ
// s:
// p: Y * Y *
