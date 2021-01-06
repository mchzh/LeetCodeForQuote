class Solution {
    // lcs
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        word1 = "#" + word1;
        word2 = "#" + word2;
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j], Math.max(dp[i-1][j], dp[i][j-1]));
                }
            }
        }
        //System.out.println(dp[m][n]);
        return m+n-2*dp[m][n];
    }
}
