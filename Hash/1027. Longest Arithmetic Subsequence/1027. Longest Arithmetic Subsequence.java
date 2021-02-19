class Solution {
    public int longestArithSeqLength(int[] A) {
        int n = A.length;
        Map[] dp = new Map[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }
        
        int rets = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long diff = (long)A[i] - (long)A[j];
                if (!dp[j].containsKey(diff)) dp[j].put(diff, 1);
                int temp = (int)dp[j].get(diff)+1;
                dp[i].put(diff, Math.max((int)dp[i].getOrDefault(diff, 1), temp));
                rets = Math.max(rets, (int)dp[i].get(diff));
            }
        }
        return rets;
    }
}

//dp[i][diff]
