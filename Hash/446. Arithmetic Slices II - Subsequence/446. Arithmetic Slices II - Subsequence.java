class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        Map[] dp = new Map[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }
        
        int rets = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long diff = (long)A[i] - (long)A[j];
                if (!dp[j].containsKey(diff)) dp[j].put(diff, 0);
                int temp = (int)dp[j].get(diff)+1;
                dp[i].put(diff, (int)dp[i].getOrDefault(diff, 0) + temp);
                rets += (int)dp[j].get(diff);
            }
        }
        return rets;
    }
}

// dp[i]: the number of arithmetic slices end with i index;
// dp[i][diff]: the number of arithmetic slices i as end, diff as the common substract
// dp[i][diff]: the number of arithmetic slices i as end, diff as the common substract (len >= 2)
    
// dp[i][diff] = dp[j][diff] + 1 (diff = n[i] - n[j])
// rets += dp[j][diff];
