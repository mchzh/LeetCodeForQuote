class Solution {
    // https://leetcode.com/problems/combination-sum-iv/discuss/85036/1ms-Java-DP-Solution-with-Detailed-Explanation
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int[] comb = new int[target+1];
        comb[0] = 1;
        
        for (int sum = 1; sum <= target; sum++) {
            for (int i = 0; i < nums.length; i++) {
                if (sum-nums[i] >= 0) comb[sum] += comb[sum-nums[i]];
            }
        }
        return comb[target];
    }
}
