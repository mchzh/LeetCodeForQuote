class Solution {
    // two pass and stack(monolithic increasing stack)
    // two pointer
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int n = height.length;
        int left = 0, right = n-1;
        int rets = 0;
        int left_max =0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                // left max
                left_max = Math.max(left_max, height[left]);
                rets += left_max-height[left];
                left++;
            } else  {
                // right max
                right_max = Math.max(right_max, height[right]);
                rets += right_max-height[right];
                right--;
            }
        }
        return rets;
    }
}
