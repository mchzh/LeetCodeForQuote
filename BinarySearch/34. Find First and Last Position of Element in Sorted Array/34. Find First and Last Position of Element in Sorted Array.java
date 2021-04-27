class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] rets = new int[2];
        Arrays.fill(rets, -1);
        if (nums == null || nums.length == 0) return rets;
        int left = 0, right = nums.length-1;
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
        right = nums.length-1;
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
}
