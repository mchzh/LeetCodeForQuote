class Solution {
    vector<int>primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    long mod = (long)(1e9+7);
public:
    int numberOfGoodSubsets(vector<int>& nums) {
        vector<int>count(31, 0);
        for (int n : nums) count[n]++;
        int m = primes.size();
        vector<long>dp(1<<m);
        dp[0] = 1;

        for (int i = 0; i < count.size(); i++) {
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
    
    int getEncode(int num) {
        int ans = 0;
        for (int i = 0; i < primes.size(); i++) {
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
};
