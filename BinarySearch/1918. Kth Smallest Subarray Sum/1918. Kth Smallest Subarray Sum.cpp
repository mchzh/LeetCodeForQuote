class Solution {
public:
    int kthSmallestSubarraySum(vector<int>& nums, int k) {
        int left = INT_MAX, right = 0;
        for (int n : nums) {
            right += n;
            left = min(left, n);
        }
        
        while (left < right) {
            int mid = left + (right-left)/2;
            if (getCount(nums, mid) >= k) {
                right = mid;
            } else {
                left = mid+1; // the number of less than target < k should plus one
            }
        }
        
        return left;
    }
    int getCount(vector<int>& nums, int mid) {
        int left = 0;
        int sum = 0;
        int count = 0;
    
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
            while (sum > mid) {
                sum -= nums[left];
                left++;
            }
            count += i-left+1;
        }

        return count;
    }
};
