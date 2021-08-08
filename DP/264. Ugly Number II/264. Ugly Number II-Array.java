class Solution {
    public int nthUglyNumber(int n) {
        int i = 0, j = 0, k = 0;
        int[] rets = new int[n];
        rets[0] = 1;
        
        for (int t = 1; t < n; t++) {
            int cur = Math.min(rets[i]*2, Math.min(rets[j]*3, rets[k]*5));
            rets[t] = cur;
            
            if (cur == rets[i]*2) i++;
            if (cur == rets[j]*3) j++;
            if (cur == rets[k]*5) k++;
        }
        
        return rets[n-1];
    }
}

// ugly number = a old ugly * 2
//             = a old ugly * 3
//             = a old ugly * 5
    
// dp[t] = min(dp[i]*2, dp[i]*3, dp[i]*5);
// update(i, j, k)
