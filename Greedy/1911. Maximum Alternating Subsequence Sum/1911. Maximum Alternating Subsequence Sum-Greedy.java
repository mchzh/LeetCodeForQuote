class Solution {
    public long maxAlternatingSum(int[] nums) {
        long rets = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i+1 < n && nums[i] > nums[i+1]) rets += nums[i]-nums[i+1];
        }
        rets += nums[n-1];
        
        return rets;
    }
}
