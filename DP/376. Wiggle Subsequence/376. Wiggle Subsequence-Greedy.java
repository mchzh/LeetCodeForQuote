class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int dir = -2;
        int rets = 1;
        
        for (int i = 1; i < nums.length; i++) {
            int dir_prev = dir;
            if (nums[i] > nums[i-1]) 
                dir = 1;
            else if (nums[i] < nums[i-1]) 
                dir = -1;
            else dir = dir_prev;
            
            if (dir != dir_prev) rets += 1;
        }
        return rets;
    }
}
