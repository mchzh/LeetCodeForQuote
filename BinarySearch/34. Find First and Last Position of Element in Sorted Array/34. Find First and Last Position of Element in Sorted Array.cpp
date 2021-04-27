class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int>rets(2, -1);
        
        int left = 0, right = nums.size()-1;
        while (left < right) {
            int mid = left + (right-left)/2;
            if (nums[mid] < target) {
                left = mid+1;
            } else if (nums[mid] > target) {
                right = mid-1;
            } else {
                right = mid;
            }
        }
        if (left == right && nums[left] == target) {
            rets[0] = left;
        } 
        
        left = 0;
        right = nums.size()-1;
        while (left < right) {
            int mid = right - (right-left)/2;
            if (nums[mid] < target) {
                left = mid+1;
            } else if (nums[mid] > target) {
                right = mid-1;
            } else {
                left = mid;
            }
        }
        if (left == right && nums[right] == target) {
            rets[1] = right;
        }
        
        return rets;
    }
};
