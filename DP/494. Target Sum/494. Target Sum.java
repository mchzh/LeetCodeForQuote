class Solution {
    // dfs + prune => dp
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int[] newnums = new int[n+1];
        for (int i = 0; i < n; i++) newnums[i+1] = nums[i];
        int sum = 0;
        for (int c : nums) sum += c;
        if (sum < target) return 0;
        
        int[][] dp = new int[n+1][2*sum+1];
        dp[0][sum] = 1;
        
        for (int i = 1; i < n+1; i++) {
            for (int j = -sum; j <= sum; j++) {
                if (j+sum+newnums[i] <= 2*sum) 
                    dp[i][j+sum+newnums[i]] += dp[i-1][j+sum];
                if (j+sum-newnums[i] >= 0)
                    dp[i][j+sum-newnums[i]] += dp[i-1][j+sum];
            }
        }
        return dp[n][target+sum];
    }
}
// dp[s+num[i]]: dpi-1[s]
// dp[s-num[i]]: dpi-1[s]
