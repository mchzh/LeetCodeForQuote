class Solution {
    // bp -> dp
    // 0/1 knapsack detailed explanation
    // https://leetcode.com/problems/partition-equal-subset-sum/discuss/90592/01-knapsack-detailed-explanation
    public boolean canPartition(int[] nums) {
        // dp[i][j] means whether the specific sum j can be gotten from the first i numbers
        if (nums == null || nums.length == 0) return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        if ( (sum&1) == 1 ) return false;
        sum /= 2;
        
        boolean[] visited = new boolean[nums.length];
        return helper(nums, 0, 0, sum, visited);
    }
    private boolean helper(int[] nums, int pos, int curSum, int target, boolean[] visited) {
        if (pos == nums.length) return false;
        if (curSum > target) return false;
        else if (curSum == target) return true;
        
        /*if (helper(nums, pos+1, curSum+ nums[pos], target)) return true;
        if (helper(nums, pos+1, curSum, target)) return true;*/
        for (int i = pos; i < nums.length; i++) {
            if (visited[i]) continue;
            if (i >= 1 && nums[i] == nums[i-1] && visited[i-1] == false) continue;
            // solve the duplicate element issue -> [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,100]
            
            visited[i] = true;
            if (helper(nums, pos+1, curSum+ nums[i], target, visited)) return true;
            visited[i] = false;
        }
        return false;
    }
    
    public boolean canPartitionDP(int[] nums) {
        // dp[i][j] means whether the specific sum j can be gotten from the first i numbers
        if (nums == null || nums.length == 0) return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        if ( (sum&1) == 1 ) return false;
        sum /= 2;
        
        int n = nums.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        
        for (boolean[] d : dp) {
            Arrays.fill(d, false);
        }
        dp[0][0] = true;
        for (int i = 1; i < n+1; i++) {
            dp[i][0] = true;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] |= dp[i-1][j];
                if (j >= nums[i-1]) dp[i][j] |= dp[i-1][j-nums[i-1]];
            }
        }
        return dp[n][sum];
    }
}

/*class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums)
            sum += n;
        if(sum % 2 != 0) 
            return false;
        sum = sum/2;
        boolean[] dp = new boolean[sum+1];
        Arrays.fill(dp, false);
        dp[0] = true;
        
        for(int n : nums){
            for(int i = sum; i > 0; i--){
                if(i >= n){
                    dp[i] = dp[i] || dp[i-n];
                }
            }
        }
        return dp[sum];
    }
}*/
