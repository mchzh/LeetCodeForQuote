class Solution {
public:
    int findTargetSumWays(vector<int>& nums, int target) {
        int sum = accumulate(nums.begin(), nums.end(), 0);
        if (target > sum || target < -sum) return 0;
        
        int offset = sum;
        vector<int>dp(2*offset+1);
        dp[0+offset] = 1;
        
        for (auto x : nums) {
            auto old_dp = dp;
            for (int i = -offset; i <= offset; i++) {
                dp[i+offset] = 0;
                
                if (i-x >= -offset) dp[i+offset] += old_dp[i+offset-x];
                if (i+x <= offset) dp[i+offset] += old_dp[i+offset+x];
            }
        }
        return dp[target+offset];
    }
};
