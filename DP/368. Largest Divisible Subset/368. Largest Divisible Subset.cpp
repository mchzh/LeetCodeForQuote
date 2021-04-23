class Solution {
public:
    vector<int> largestDivisibleSubset(vector<int>& nums) {
        int n = nums.size();
        vector<int>dp(n, 0);
        vector<int>prev(n, -1);
        sort(nums.begin(), nums.end());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] != 0) continue;
                if (dp[i] >= dp[j]+1) continue;
                dp[i] = dp[j]+1;
                prev[i] = j;
            }
        }
        int idx = 0;
        int rets = 0;
        for (int i = 0; i < n; i++) {
            if (rets >= dp[i]) continue;
            rets = dp[i];
            idx = i;
        }
        vector<int>list;
        while (idx != -1) {
            list.push_back(nums[idx]);
            idx = prev[idx];
        }
        return list;
    }
};
