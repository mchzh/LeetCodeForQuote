class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0, right = nums.length-1;
        int mid;
        while (left < right) {
            while (left+1 < right && nums[left] == nums[left+1]) left++;
            mid = left + (right-left)/2;
            if (left == right-1) return Math.min(nums[left], nums[right]);
           
            if (nums[mid] > nums[left]) { // left range
                if (nums[left] >= nums[right]) {
                    left = mid+1;
                } else right = mid;
            } else { // right range
                if (nums[left] >= nums[right]) {
                    right = mid;
                } else continue;
            }
        }
        return nums[left];
    }
}

// ------- -----
//        -
// [1,3,5]
// [2,2,2,0,1]
// [3,1,3]
// [1,3,3]
// [3,3,3,1]
// [10,1,10,10,10]
// [2,2,2,2,0,1,2,2]
// [2,2,3,4,2,2,2,2]
