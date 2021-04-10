class Solution {
public:
    int nthUglyNumber(int n) {
        int nums[n];
        nums[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < n; i++) {
            nums[i] = min(nums[a]*2, min(nums[b]*3, nums[c]*5));
            if (nums[a]*2 == nums[i]) a++;
            if (nums[b]*3 == nums[i]) b++;
            if (nums[c]*5 == nums[i]) c++;
        }
        return nums[n-1];
    }
};
