class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0, right = nums.length-1;
        while (left < right) {
            int mid = left + (right-left)/2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                right -= 1;
            }
        }
        return nums[left];
    }
}

// ------- -----
//        -
// [2,2,2,2,0,1,2,2]
// [2,2,2,3,4,2,2,2,2]
