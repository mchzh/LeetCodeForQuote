class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newnums = new int[n+2];
        for (int i = 0; i < n; i++) {
            newnums[i+1] = nums[i];
        }
        newnums[0] = 1;
        newnums[n+1] = 1;
        int[][] dp = new int[n+2][n+2];
        
        // first loop to check len
        for (int len = 1; len <= n; len++) {
            for (int i = 1; i+len-1 <= n ; i++) {
                int j = i+len-1;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k-1] + dp[k+1][j] + newnums[k]*newnums[i-1]*newnums[j+1]);
                }
            }
        }
        return dp[1][n];
    }
}
// range dp

// dp[i][j]: the maximum coins you can collect by bursting the balloons on s[i...j]

// i X X X X X [k] X X X X j
//          k is last burst indice
           
// dp[i][j] = max(dp[i][k-1] + dp[k+1][j] + nums[k]*nums[i-1]*nums[j+1]);
