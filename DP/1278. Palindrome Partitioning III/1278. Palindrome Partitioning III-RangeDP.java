class Solution {
    public int palindromePartition(String s, int k) {
        int n = s.length();
        s = "#" + s;
        int[][] count = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) count[i][i] = 0;
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i+len-1 <= n; i++) {
                int j = i+len-1;
                if (s.charAt(i) == s.charAt(j)) count[i][j] = count[i+1][j-1];
                else count[i][j] = count[i+1][j-1]+1;
            }
        }
        
        int[][] dp = new int[n+1][k+1];
        for (int[] d : dp) Arrays.fill(d, Integer.MAX_VALUE/2);
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int t = 1; t <= Math.min(i, k); t++) {
                for (int j = t; j <= i; j++) {
                    dp[i][t] = Math.min(dp[i][t], dp[j-1][t-1]+count[j][i]);
                }
            }
        }
        return dp[n][k];
    }
}
//dp[i][k] = min(dp[j-1][k-1]+helper()) j [1:i]
