class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size();
        vector<int>q;
        
        for (int x : nums) {
            auto pos = lower_bound(q.begin(), q.end(), x); // element
            if (pos == q.end()) {
                q.push_back(x);
            } else {
                *pos = x;
            }
        }
        
        return q.size();
    }
    
    int lengthOfLISDpbasic(vector<int>& nums) {
        int n = nums.size();
        vector<int>dp(n, 1);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = max(dp[i], dp[j]+1);
                }
            }
        }
        // get the final result
        int ret = 0;
        for (int i = 0; i < n; i++) {
            ret = max(ret, dp[i]);
        }
        return ret;
    }
};
// basic dp O(n2)
// dp + binary search: always keep a increasing sequence array with a more lower height
