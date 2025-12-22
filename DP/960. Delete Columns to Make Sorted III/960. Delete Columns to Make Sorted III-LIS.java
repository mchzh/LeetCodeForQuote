class Solution {
    public int minDeletionSize(String[] strs) {
        int m = strs.length, n = strs[0].length();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int j = 1; j < n; j++) {
            // for previous coloumn to check every row
            for (int t = 0; t < j; t++) {
                if (isIncrease(strs, t, j)) {
                    dp[j] = Math.max(dp[j], dp[t] + 1);
                }
            }
        }

        int rets = 0;
        for (int j = 0; j < n; j++) {
            rets = Math.max(rets, dp[j]);
        }
        return n-rets;
    }

    private boolean isIncrease(String[] strs, int s, int t) {
        int m = strs.length;
        for (int i = 0; i < m; i++) {
            if (strs[i].charAt(s) > strs[i].charAt(t)) return false;
        }
        return true;
    }
}

// dp[i]: end with i column make icolumn all element >= befort ith column element
// dp[i] = dp[j] + 1; strs[c][j] <= strs[c][i] c -> 0 .... m-1
