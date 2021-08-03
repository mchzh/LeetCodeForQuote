using LL = long long;
class Solution {
    LL mod = 1e9+7;
public:
    int countSpecialSubsequences(vector<int>& nums) {
        vector<LL>dp(3);
        
        dp[0] = 1;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == 0)
                dp[0] = (dp[0]*2)%mod; // cur 0 sel or non-sel
            else if (nums[i] == 1)
                dp[1] = (dp[0]-1 + dp[1]*2)%mod; // remove the empty calculation
            else if (nums[i] == 2)
                dp[2] = (dp[1] + dp[2]*2)%mod;
        }
        
        return dp[2];
    }
};
