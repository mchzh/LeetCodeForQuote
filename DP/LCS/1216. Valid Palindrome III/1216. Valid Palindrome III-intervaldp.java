class Solution {
    public boolean isValidPalindrome(String s, int k) {
        int N = s.length();
        int[][] dp = new int[N][N];
        dp[0][0] = 1;
        for (int i = N-1; i >=0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < N; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }
        return s.length() - dp[0][N-1] <= k;
    }
}
