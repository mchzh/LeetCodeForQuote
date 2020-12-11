class Solution {
    public int removeDuplicates(int[] nums) {
        //doble pointer
        if (nums == null || nums.length == 0) return 0;
        
        int left = 0, n = nums.length;
        int count = 1;
        for (int i = 0; i < n; i++) {
            if (i == 0) continue;
            if (nums[i] == nums[i-1] && count >= 2) continue;
            
            left++;
            if (nums[i] != nums[i-1]) count=1;
            else count++;
            nums[left] = nums[i];
            // if (nums[i] != nums[i-1]) {
            //     left++;
            //     nums[left] = nums[i];
            //     count=1;
            // } else if (nums[i] == nums[i-1]) {
            //     if (count < 2) {
            //         left++;
            //         nums[left] = nums[i];
            //         count++;
            //     }
            // }
        }
        return left+1;
    }
}
