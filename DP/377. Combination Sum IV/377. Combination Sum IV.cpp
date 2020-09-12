class Solution {
public:
    int combinationSum4(vector<int>& nums, int target) {
        //if (nums == null || nums.size() == 0) return 0;
        vector<unsigned int>dp(target+1, 0);
        dp[0] = 1;
        
        for (int sum = 1; sum <= target; sum++) {
            for (int i = 0; i < nums.size(); i++) {
                if (sum-nums[i] >= 0) dp[sum] += dp[sum-nums[i]];
            }
        }
        return dp[target];
    }
};
