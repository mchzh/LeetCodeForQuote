class Solution {
    public int palindromePartition(String s, int k) {
        int n = s.length();
        s = "#" + s;
        // first part dp
        int[][] count = new int[n+1][n+1];
        
        for (int len = 1; len <= n; len++) {
            for (int i = 1; i+len-1 <= n; i++) {
                int j = i+len-1;
                if (s.charAt(i) != s.charAt(j)) count[i][j] += 1;
                if (i < j-2)
                    count[i][j] += count[i+1][j-1];
            }
        }
        
        // second part dp
        int[][] dp = new int[n+1][k+1];
        for (int[] d : dp) {
            Arrays.fill(d, Integer.MAX_VALUE/2);
        }
        
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int t=1; t <= Math.min(i, k); t++) {
                for (int j = t; j <= i; j++) {
                    //dp[i][t] = Math.min(dp[i][t], dp[j-1][t-1] + helper(s, j, i));
                    dp[i][t] = Math.min(dp[i][t], dp[j-1][t-1] + count[j][i]);
                }
            }
        }
        return dp[n][k];
    }
}
