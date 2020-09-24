class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int max_cur = nums[0], min_cur = nums[0], result = nums[0];
        for (int i = 1; i < nums.size(); i++) {
            int newMax = max(nums[i], max(max_cur*nums[i], min_cur*nums[i]) );
            int newMin = min(nums[i], min(max_cur*nums[i], min_cur*nums[i]) );
            max_cur = newMax;
            min_cur = newMin;
            result = max(result, max_cur);
        }
        return result;
    }
};

// Max sum subarray
// kadane

// X X X X] X X X
// max_sum_ending_here

// dp[i] = max(dp[i-1] + x, x);

// dp[i] = max(dp[i-1] * x, x);

// [-1, -2, -3]
//  dp1[0] = -1;
//  dp1[1] = 2;
//  dp1[2] = -3;

// dp = max (2*-3, -3, -2*-3);
// dp1[i] = max(dp1[i-1] * x, x, dp2[i-1]*x);
// dp2[i] = min(dp1[i-1] * x, x, dp2[i-1]*x);

// dp1 cur_max, dp2 cur_min
