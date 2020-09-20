class Solution {
    int[] memo;
    public int rob(int[] nums) {
        // top to bottom
        if (nums == null || nums.length == 0) return 0;
        memo = new int[nums.length];
        Arrays.fill(memo, Integer.MIN_VALUE);
        return dfs(nums, nums.length-1);
    }
    public int dfs(int[] nums, int pos) {
        // base case
        if (pos < 0) return 0;
        if (memo[pos] != Integer.MIN_VALUE) return memo[pos];
        // rob current
        int robVal = dfs(nums, pos-2) + nums[pos];
        // norob current
        int norobVal = dfs(nums, pos-1);
        int ret = Math.max(robVal, norobVal);
        memo[pos] = ret;
        return ret;
    }
    // dp
    public int robDp(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // last house status
        int N = nums.length;
        int select = 0;
        int non_select = 0;
        for (int i = 0; i < nums.length; i++) {
            int os = select, ons = non_select;
            select = ons + nums[i];
            non_select = Math.max(os, ons);
        }
        return Math.max(select, non_select);
    }
}

//   k              k-1
// select[k]         non-select[k-1]
// non-select[k]     select or non-select[k-1]

// s[k] = ns[k-1] + nums[i];
// ns[k] = max(s[k-1], ns[k-1]);

/*class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // dp
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < nums.length + 1; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
        }
        return dp[nums.length];
    }
}*/
