class Solution {
    // https://leetcode.com/problems/domino-and-tromino-tiling/discuss/116581/Detail-and-explanation-of-O(n)-solution-why-dpn2*dn-1%2Bdpn-3
    public int numTilings(int N) {
        int mod = 1000000007;
        int[] dp = new int[N +1];
        dp[0] = 1;
        if (N >= 1) dp[1] = 1;
        if (N >= 2) dp[2] = 2;
        if (N >= 3) dp[3] = 5;
        if (N<= 3) return dp[N];
        for (int i = 4; i < N+1; i++) {
            dp[i] = dp[i-3] % mod + (2*dp[i-1]) % mod;
            dp[i] %= mod;
        }
        return dp[N];
    }
}

// dp[n] = dp[n-1] + dp[n-2] + 2* (dp[n-3] + --- + dp[0]);
//       = dp[n-1] + dp[n-2] + dp[n-3] + dp[n-3] + 2* (dp[n-4] + --- + dp[0]);
//       = dp[n-1] + dp[n-3] + {dp[n-2] + dp[n-3] + 2* (dp[n-4] + --- + dp[0])};
//       = dp[n-1] + dp[n-3] + dp[n-1];
//       = dp[n-3] + 2* dp[n-1];

/*class Solution {
    static int mod = 1000000007;
    public int numTilings(int N) {
        return (int)numTilings(N, new long[N + 1]);
    }
    
    public long numTilings(int N, long[] dp) {
        if(N <= 0) return 0;
        if(N == 1) return dp[N] = 1;
        if(N == 2) return dp[N] = 2;
        if(N == 3) return dp[N] = 5;

        if(dp[N] != 0) return dp[N] % mod;
        
        dp[N] = 2*numTilings(N - 1, dp) + numTilings(N - 3, dp);
        dp[N] %= mod;
        
        return dp[N];
    }
}*/
