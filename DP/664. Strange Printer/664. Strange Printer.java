class Solution {
    public int strangePrinter(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int[][] dp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1; // len == 1
        }
        
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n-len; i++) {
                int j = i+len-1;  // j-i+1 = len
                dp[i][j] = 1+dp[i+1][j];  // initialize: worst case print single one
                for (int k = i+1; k <= j; k++) {
                    if (s.charAt(i) == s.charAt(k)) 
                        dp[i][j] = Math.min( dp[i][j], dp[i][k-1] + (k+1 > j ? 0 : dp[k+1][j]) );
                }
                //System.out.println(i + " " + j + " " + dp[i][j]);
            }
        }
        return dp[0][n-1]; // range from 0 to n-1
    }
}


// a X X X X X a X X X 
//             k
// i                  j

// dp[i][j] = min(dp[i][j],dp[i][k-1] + dp[k+1][j]);
