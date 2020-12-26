class Solution {
    // dp for different situation
    public int numDecodings(String s) {
        int n = s.length();
        int mod = 1000000007;
        s = "0"+s;
        long[] dp = new long[n+1];
        dp[0] = 1; // virtual node
        for (int i = 1; i <= n; i++) {
            if (dp[i-1] == 0) return 0;
            char c = s.charAt(i);
            
            if (c >= '1' && c <= '9') dp[i] += dp[i-1];
            else if (c == '*') {
                dp[i] += 9*dp[i-1];
            }
            
            // i-2
            if (i > 1) {
                char prevc = s.charAt(i-1);
                if (prevc == '*' && c == '*') {
                    dp[i] += 15*dp[i-2]; // ? for signle char '*' only represent from '1' to '9'
                } else if (prevc == '*') {
                    if (c >= '0' && c <= '6') dp[i] += 2*dp[i-2];
                    else dp[i] += dp[i-2];
                } else if (c == '*') {
                    if (prevc == '1') dp[i] += 9*dp[i-2];
                    if (prevc == '2') dp[i] += 6*dp[i-2];
                } else if (prevc== '1' || (prevc == '2' && c<='6' )) {
                    dp[i] += dp[i-2];
                }
            }
            dp[i] %= mod;
            
        }
        return (int)(dp[n]%mod);
    }
}

// * X X: += dp[i-2]
// 1 * : 9*dp[i-2]
// 2 * : 6*dp[i-2]
