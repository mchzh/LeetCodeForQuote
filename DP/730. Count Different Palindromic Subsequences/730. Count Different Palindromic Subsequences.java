class Solution {
    public int countPalindromicSubsequences(String S) {
        int n = S.length();
        String s = "#" + S;
        long[][] dp = new long[n+1][n+1];
        long mod = (long) (1e9+7);
        
        int[][] next = new int[n+1][4];
        int[][] prev = new int[n+1][4];
        for (int[] x : next) Arrays.fill(x, Integer.MAX_VALUE/2);
        for (int[] p : prev) Arrays.fill(p, Integer.MIN_VALUE/2);
        for (int k = 0; k < 4; k++) {
            int i = 0;
            for (int j = 0; j <= n; j++) {
                if (s.charAt(j)-'a' != k) continue;
                while (i <= j) {
                    next[i][k] = j;
                    i++;
                }
            }
        }
        for (int k = 0; k < 4; k++) {
            int i = n;
            for (int j = n; j >= 0; j--) {
                if (s.charAt(j)-'a' != k) continue;
                while (i >= j) {
                    prev[i][k] = j;
                    i--;
                }
            }
        }
        
        for (int i = 0; i <= n; i++) {
            dp[i][i] = 1;
        }
        
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n-len+1; i++) {
                int j = i+len-1;
                for (int k = 0; k < 4; k++) {
                    int p = next[i][k];
                    int q = prev[j][k];
                    
                    if (p < q) dp[i][j] += dp[p+1][q-1] + 1;
                    
                    if (next[i][k] <= j) dp[i][j] += 1; // corner case
                    dp[i][j] %= mod;
                }
            }
        }
        
        return (int)dp[1][n];
    }
}

// dp[i][j]: the number of different non-empty palindromic subsequences in S[j...i] with form a_a, b_b, c_c, d_d

// jXXXXXXi
// jaxxxaxxi : s[i] == s[j] or s[i] != s[j]
// for (len 1-n) {
//     for (i 1~n-len+1) {
//         int j = i+len-1;
//         for (char a~d) {
//             int p = next[j][ch];
//             int q = prev[i][ch]
//             dp[i][j] = dp[p+1][q-1] + 1;
//         }
//     }
// }
// "bccb"
// b[cc]b -> [cc]+a(b_b) and plus only one 'b' <- corner case
