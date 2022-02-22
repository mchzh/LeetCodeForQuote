class Solution {
    int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    long mod = (long)(1e9+7);
    public int numberOfGoodSubsets(int[] nums) {
        int[] count = new int[31];
        for (int n : nums) count[n]++;
        int m = primes.length;
        long[] dp = new long[1<<m];
        dp[0] = 1;

        for (int i = 0; i < count.length; i++) {
            int cur = i;
            int num = count[i];
            if (num == 0) continue;
            if (cur == 1) continue;
            int encode = getEncode(cur);
            if (encode == -1) continue;

            for (int state = (1<<m)-1; state >= 1; state--) {
                if ( (state&encode) == encode) {
                    dp[state] += dp[state-encode]*count[cur];
                    dp[state] %= mod;
                }
            }
        }
        //System.out.println(count[1]);

        long rets = 0;
        for (int state = (1<<m)-1; state >= 1; state--) {
            rets = (rets + dp[state])%mod;
        }
        // get power of 1
        long power2 = 1;
        for (int j = 0; j < count[1]; j++) {
            power2 = (power2*2)%mod;
        }

        return (int)((rets*power2)%mod);
    }
    
    private int getEncode(int num) {
        int ans = 0;
        for (int i = 0; i < primes.length; i++) {
            int p = primes[i];
            if (num%p == 0) {
                num /= p;
                ans += (1<<i);
            }
            if (num%p == 0) {
                return -1;
            }
        }
        return ans;
    }
}

// valid array: [2, 3, 5, 6, 7, 10, 11, 13, 14, 15, 17, 19, 21, 22, 23, 26, 29, 30]

// prime:  [2, 3, 5, 7, 11, 13, 17, 19, 23, 29]
//          ^.    ^.        ^
// backsnap
// dp[state] = dp[state-subset] ++ 10;
// for (int num : nums) {
//     for (int state = (1<<n)-1; state >= 1; state--) {
//         if (subset is the combination of state) {
//             dp[state] += dp[state-subset]*1;
//         }
//     }
// }
// ret = sum(dp[state]);
// return ret * 2^count[1]

// [2,5,7,13] = [7,13] ++ 10
// 1 can be set any nubmers of existed count
