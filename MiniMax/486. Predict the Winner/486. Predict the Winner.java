class Solution {
    // https://cloud.tencent.com/developer/article/1454880
   // https://leetcode.com/problems/predict-the-winner/solution/ //https://www.liuin.cn/2018/06/30/LeetCode%E6%80%BB%E7%BB%93%E2%80%94%E2%80%94Minimax%E7%AE%97%E6%B3%95/
    public boolean PredictTheWinner(int[] nums) {
        // use recursion
        if (nums == null || nums.length <= 1) return true;
        // minimax rules
        int len = nums.length;
        int[][] dp = new int[len][len];
        int[][] opdp = new int[len][len];
        int sum = 0;
        for (int num : nums) sum += num;
        
        for (int j = 0; j < len; j++) {
            dp[j][j] = nums[j]; // edge case
            for (int i = j-1; i >= 0; i--) {
                dp[i][j] = Math.max(nums[i] + opdp[i+1][j], nums[j] + opdp[i][j-1]);
                opdp[i][j] = Math.min(dp[i+1][j], dp[i][j-1]);
            }
        }
        return dp[0][len-1] >= (sum+1)/2;
    }
}

// iXXXXXXXXXXXXXj
// f[][] : max(ai + s[i+1][j], aj + s[i][j-1]);
//     s[i][j] = min(f[][], f[][]); our profit after opponent take one number
