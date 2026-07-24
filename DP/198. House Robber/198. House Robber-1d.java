class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[2];
        dp[0] = nums[0];
        
        for (int i = 1; i < n; i++) {
            int[] newdp = new int[2];
            newdp[0] = dp[1] + nums[i];
            newdp[1] = Math.max(dp[0], dp[1]);
            // update dp as new dp
            dp[0] = newdp[0];
            dp[1] = newdp[1];
        }
        return Math.max(dp[0], dp[1]);
    }
}
// dp[i]: dp[i-2] not i-1
// max(dp[i], dp[i-2]+ val)
// rob or not rob
// dp0: rob, fp1: not rob
// dp0 rob = olddp1 + val
// dp1 not rob = olddp0, olddp1 without plud current val
