class Solution {
public:
    int findLengthOfLCIS(vector<int>& nums) {
        // slide window
        int n = nums.size();
        int i =0, j = 0;
        int rets = 0;
        while (j < n) {
            if (j-1>=0 && nums[j] <= nums[j-1]) {
                i=j;
            }
            rets = max(rets, j-i+1);
            j++;
        }
        return rets;
    }
};
