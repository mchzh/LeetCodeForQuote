class Solution {
    // dp
    long mod = (long)(1e9+7);
    public int colorTheGrid(int m, int n) {
        // get the valided states
        int last = (int)Math.pow(3, m);
        List<Integer> validstate = new ArrayList<>();
        for (int state = 0; state < last; state++) {
            if (isValid(state, m)) {
                validstate.add(state);
            }
        }
        
        // dp definition and initilize
        int len = validstate.size();
        long[] dp_old = new long[last];
        long[] dp_new = new long[last];
        for (int s : validstate) dp_old[s] = 1;
        
        // current column depends on the previous column with state
        for (int i = 1; i < n; i++) {
            for (int s = 0; s < len; s++) { // new state
                dp_new[validstate.get(s)] = 0;
                for (int t = 0; t < len; t++) {
                    int statenew = validstate.get(s);
                    int stateold = validstate.get(t);
                    if (checkok(s, t, validstate, m)) {
                        dp_new[statenew] = (dp_new[statenew]+dp_old[stateold])%mod;
                    }
                }
            }
            dp_old = Arrays.copyOf(dp_new, last);
        }
        
        long rets = 0;
        for (long d : dp_old) {
            rets = (rets+d)%mod;
        }
        return (int)rets;
    }
    
    private boolean isValid(int num, int times) {
        int prev = -1;
        for (int i = 0; i < times; i++) {
            int cur = num%3;
            if (cur == prev) return false;
            num /= 3;
            prev = cur;
        }
        return true;
    }
    private boolean checkok(int s, int t, List<Integer> validstate, int times) {
        int a = validstate.get(s);
        int b = validstate.get(t);
        for (int i = 0; i < times; i++) {
            if (a%3 == b%3) return false;
            a/=3;
            b/=3;
        }
        return true;
    }
}
// dp[i][state]: i column and state
// dp[i][state] = dp[i-1][s1] + dp[i-1][s2] + .. dp[i-1][sn]

// 3^5= 243: 01201210 X00001111222
