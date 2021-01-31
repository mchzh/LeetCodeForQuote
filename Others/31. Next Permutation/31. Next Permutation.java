class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int right = n-1;
        while (right-1 >= 0 && nums[right] <= nums[right-1]) {
            right--;
        }
        // the previous element of this peak
        int left = right-1;
        if (left >= 0) {
            while (right+1 < n && nums[right+1] > nums[left]) {
                right++;
            }
            // swap left and right
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        
        // rever the rest part after left
        reverse(nums, left+1, n-1);
    }
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
