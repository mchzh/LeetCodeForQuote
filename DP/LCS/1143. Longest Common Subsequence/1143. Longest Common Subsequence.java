class Solution {
    // dp[i][j]
    public int longestCommonSubsequence(String text1, String text2) {
        int M = text1.length(), N = text2.length();
        int[][] dp = new int[M+1][N+1];
        // set default val
        //dp[0][0] = 0;
        
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + 1);
                }
            }
        }
        return dp[M][N];
    }
    
}


 // x x x x x x   i
 // y y y y y   j
 // i == j dp[][]+1
 // i != j max(dp[i-1][j] + dp[i][j-1])
