class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // prev or slide window
        int N = nums.length;
        int max = 0;
        int left = 0;
        int prev = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] <= prev) {
                prev = nums[i];
                left = i;
                continue;
            }
            max = Math.max(max, i-left+1);
            prev = nums[i];
        }
        return max;
    }
}

/*class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // slide window
        int res = 0;
        int left = 0, right = 0, len = nums.length;
        while (right < len) {
            if (right == left || nums[right] > nums[right-1]) {
                res = Math.max(res, right-left+1);
            } else {
                left = right;
            }
            right++;
        }
        return res;
    }
}*/

/*class Solution {
    public int findLengthOfLCIS(int[] nums) {
        
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int i = 0;
        int max = 1;
        
        for(int j = 1; j < nums.length; j++) {
            if(nums[j] <= nums[j - 1]) {
                i = j;
            }
            max = Math.max(max, j - i + 1);
        }
        
        return max;
    }
}*/
