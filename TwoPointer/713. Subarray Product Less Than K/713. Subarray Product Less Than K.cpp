class Solution {
public:
    int numSubarrayProductLessThanK(vector<int>& nums, int k) {
        // fix the right boundary
        int n = nums.size();
        int prod = 1;
        int j = 0;
        int count = 0;
        for (int i = 0;  i < n; i++) {
            if (j < i) {
                j = i;
                prod = 1;
            }
            while (j < n && prod*nums[j] < k) {
                prod *= nums[j];
                j++;
            }
            count += j-i;
            prod /= nums[i];
        }
        return count;
    }
};

// X [X X X X X] X) X
//    i          j
   
// 10, *, *, * k = 5
