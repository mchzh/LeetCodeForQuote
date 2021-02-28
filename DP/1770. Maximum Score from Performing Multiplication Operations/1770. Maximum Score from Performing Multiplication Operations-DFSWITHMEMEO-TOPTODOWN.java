class Solution {
    // int n, m;
    // int[] nums, muls;
    // Integer[][] memo;
    // public int maximumScore(int[] nums, int[] muls) {
    //     n = nums.length;
    //     m = muls.length;
    //     this.nums= nums;
    //     this.muls = muls;
    //     this.memo = new Integer[m+1][m+1];
    //     return dp(0, 0);
    // }
    // private int dp(int l, int i) {
    //     if (i == m) return 0; // Picked enough m operations
    //     if (memo[l][i] != null) return memo[l][i];
    //     int pickLeft = dp(l+1, i+1) + nums[l] * muls[i]; // Pick the left side
    //     int pickRight = dp(l, i+1) + nums[n-(i-l)-1] * muls[i]; // Pick the right side
    //     return memo[l][i] = Math.max(pickLeft, pickRight);
    // }
//     public int maximumScore(int[] nums, int[] multipliers) {
//         int answer = 0;
        
//         int[][] dp = new int[nums.length][multipliers.length];
//         answer = runDp(nums, 0, nums.length - 1, multipliers, 0, dp);
        
//         return answer;
//     }
    
//     private int runDp(int[] nums, int start, int end, int[] multipliers, int opCount, int[][] dp) {
//         if (opCount >= multipliers.length || start > end)
//             return 0;
        
//         if (dp[start][opCount] != 0)
//             return dp[start][opCount];

//         int val1 = nums[start] * multipliers[opCount] + runDp(nums, start + 1, end, multipliers, opCount + 1, dp);
//         int val2 = nums[end] * multipliers[opCount] + runDp(nums, start, end - 1, multipliers, opCount + 1, dp);
        
        
//         dp[start][opCount] = Math.max(val1, val2);
        
//         return dp[start][opCount];
//     }
    int[][] dp;
    int[] nums;
    int[] multipliers;
    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length, m = multipliers.length;
        this.nums = nums;
        this.multipliers = multipliers;
        dp = new int[n+1][m+1];
        
        return dfs(0, 0, n-1);
    }
    private int dfs(int pos, int left, int right) {
        if (pos == multipliers.length) {
            return 0;
        }
        if (dp[left][pos] != 0) return dp[left][pos];
        
        int start = multipliers[pos]*nums[left] + dfs(pos+1, left+1, right);
        int end = multipliers[pos]*nums[right] + dfs(pos+1, left, right-1);
        dp[left][pos] = Math.max(start, end);
        return dp[left][pos];
    }
}
