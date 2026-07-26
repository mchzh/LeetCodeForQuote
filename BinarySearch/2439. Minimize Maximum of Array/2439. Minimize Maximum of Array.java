class Solution {
    public int minimizeArrayValue(int[] nums) {
        int left = nums[0], right = (int)1e9;
        while (left < right) {
            int mid = left + (right-left)/2;

            long buffer = 0;
            boolean flag = true;
            for (int i = 0; i < nums.length; i++) {
                // buffer is need to added into the bottom
                if (nums[i] > mid) {
                    buffer -= nums[i] - mid;
                } else {
                    buffer += mid-nums[i];
                }
                if (buffer < 0) {
                    flag = false;
                    break;
                }
            }
            

            // OK ?
            if (flag) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }
}
