class Solution {
    // opposite direction
    // get two direction lis and compaer left and right remove number
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] leftlis = new int[n];
        int[] rightlis = new int[n];
        Arrays.fill(leftlis, 1);
        Arrays.fill(rightlis, 1);
        for (int i = 1; i < n ; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) leftlis[i] = Math.max(leftlis[i], leftlis[j]+1);
            }
        }
        for (int i = n-2; i >= 0 ; i--) {
            for (int j = n-1; j > i; j--) {
                if (nums[i] > nums[j]) rightlis[i] = Math.max(rightlis[i], rightlis[j]+1);
            }
        }
        int rets = Integer.MAX_VALUE;
        for (int i = 1; i < n-1 ; i++) {
            if (leftlis[i] != 1 && rightlis[i] != 1) rets = Math.min(rets, i+1-leftlis[i]+n-i-rightlis[i]);
        }
        return rets;
    }
}
