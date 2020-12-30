class Solution {
    //0-1 knapsack
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        // initilized value
        
        for (int k = 0; k < strs.length; k++) {
            int ones = 0, zeros = 0;
            for (char c : strs[k].toCharArray()) {
                if (c == '1') ones++;
                else zeros++;
            }
            
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-zeros][j-ones] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
