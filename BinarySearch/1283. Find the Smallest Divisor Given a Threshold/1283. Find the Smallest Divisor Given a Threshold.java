class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = 1000000;
        while (left < right) {
            int mid = left  + (right - left) / 2;
            int curSum = getDivSum(mid, nums);
            if (curSum <= threshold) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }
    private int getDivSum(int mid, int[] nums) {
        int count = 0;
        for (int i = 0;i < nums.length; i++) {
            count += nums[i]%mid == 0 ? nums[i]/mid : nums[i]/mid+1;
        }
        return count;
    }
}

// binary search by val/index

// /div < thres: div--
// > thres: div++
