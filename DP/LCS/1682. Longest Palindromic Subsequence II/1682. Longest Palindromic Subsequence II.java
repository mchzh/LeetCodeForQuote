class Solution {
    public int longestPalindromeSubseq(String s) {
        int N = s.length();
        s = "#" + s;
        
        int[][][] dp = new int[N+1][N+1][27];
        
        int ans = 0;
        for (int len = 2; len <= N; len++) {
            for (int i = 1; i <= N-len+1; i++) {
                int j = i+len-1;
                if (len == 2) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j][s.charAt(i)-'a'] = 2;
                        ans = Math.max(ans, dp[i][j][s.charAt(i)-'a']);
                    }
                } else {
                    for (int k = 0; k < 26; k++) {
                        // select or non-select
                        if (s.charAt(i) == s.charAt(j)) {
                            if ( (s.charAt(i)-'a') != k ) {
                                dp[i][j][s.charAt(i)-'a'] = Math.max(dp[i][j][s.charAt(i)-'a'], dp[i+1][j-1][k] + 2);
                                ans = Math.max(ans, dp[i][j][s.charAt(i)-'a']);
                            }
                        }
                        dp[i][j][k] = Math.max(Math.max(dp[i+1][j][k], dp[i][j-1][k]), Math.max(dp[i+1][j-1][k], dp[i][j][k]));
                    }
                }
            }
        }
        
        return ans;
    }
}

// X X X X i X X j
// dp[i][j][k] = dp[i+1][j-1][k`] + 2 (s[i] == s[j] && k` != k)

// even length: dp[i][i] = 0, only one element
