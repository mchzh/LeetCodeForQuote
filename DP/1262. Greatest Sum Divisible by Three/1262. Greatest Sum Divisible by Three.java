class Solution {
    public int maxSumDivThree(int[] nums) {
        // 2d to reduce 1d
        int[] dp = new int[3];
        dp[0] = 0;
        dp[1] = Integer.MIN_VALUE;
        dp[2] = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int[] oldDP = Arrays.copyOf(dp, 3);
            for (int j = 0; j < 3; j++) {
                int k = nums[i]%3;
                dp[j] = Math.max(oldDP[j], oldDP[(j-k+3)%3] + nums[i]); 
            }
        }
        
        return dp[0];
    }
}

// dp[i][j]: the maximum possible sum (%3 == j) of elements of the array from nums[1...i].
    
// 1. select nums[i]
//     if (nums[i] % 3 == 0)
//         dp[i][0] = dp[i-1][0] + nums[i];
//         dp[i][1] = dp[i-1][1] + nums[i];
//         dp[i][2] = dp[i-1][2] + nums[i];
//     if (nums[i] % 3 == 1)
//         dp[i][0] = dp[i-1][2] + nums[i];
//         dp[i][1] = dp[i-1][0] + nums[i];
//         dp[i][2] = dp[i-1][1] + nums[i];
//     if (nums[i] % 3 == 2)
//         dp[i][0] = dp[i-1][1] + nums[i];
//         dp[i][1] = dp[i-1][2] + nums[i];
//         dp[i][2] = dp[i-1][0] + nums[i];

// common pattern:
//     for (int i = 0; i < n; i++) {
//         for (int j = 0; j < 3; j++) {
//             int k = nums[i]%3;
//             dp[i][j] = dp[i][(j-k+3)%3] + nums[i]; 
//         }
//     }
// 2. non-select nums[i]
//     dp[i][j] = dp[i-1][j];
