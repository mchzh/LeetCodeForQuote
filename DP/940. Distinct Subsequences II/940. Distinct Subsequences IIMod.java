class Solution {
    // long[] dp = new long[2005];
    // long mod = (long)(1e9+7);
    public int distinctSubseqII(String s) {
        // int[] last = new int[26];
        // int n = s.length();
        // s = "#"+s;
        // dp[0] = 1; // seed;

        // for (int i = 1; i <= n; i++) {
        //     char c = s.charAt(i);
        //     int j = last[c-'a'];
        //     dp[i] = (dp[i-1]*2%mod - ((j >= 1) ?  dp[j-1] : 0)%mod + mod)%mod;
        //     last[c-'a'] = i;
        //     if (i > n-5) System.out.println(i + " : " + j + " : " +  dp[i] + " : " + (dp[i-1]*2%mod) + " : " + ((j >= 1) ?  dp[j-1] : 0));
        // }

        // return (int)(dp[n] - (long)1); // not empty

        long mod = (long)(1e9+7);
        long[] dp = new long[2005];
        int n = s.length();
        s = "#" + s;
        int[] last = new int[26];
        dp[0] = 1;
        
        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i);
            int j = last[c-'a'];
            dp[i] = (2*dp[i-1]%mod - (j >= 1 ? dp[j-1] : 0));
            dp[i] = (dp[i]+mod)%mod;
            //((2*dp[i-1]%mod - (j >= 1 ? dp[j-1] : 0))+mod)%mod;
            last[c-'a'] = i;
        }
        
        return (int)((dp[n]-1+mod)%mod);
    }
}

// dp[i]: the number of distinct subsequence from s[1...i]
// dp[i] = dp[i-1]*2 - dp[j-1]
