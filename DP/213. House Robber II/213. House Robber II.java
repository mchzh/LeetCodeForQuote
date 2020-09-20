class Solution {
    public int rob(int[] nums) {
         if (nums == null || nums.length == 0) return 0;
         if (nums.length == 1) return nums[0]; // no cycle
//         // last house status
//         int N = nums.length;
//         int select = 0;
//         int non_select = 0;
//         int ret = 0;
//         for (int i = 0; i < nums.length-1; i++) {
//             int os = select, ons = non_select;
//             select = ons + nums[i];
//             non_select = Math.max(os, ons);
//         }
//         ret = Math.max(select, non_select);
//         select = 0;
//         non_select = 0;
//         for (int i = 1; i < nums.length; i++) {
//             int os = select, ons = non_select;
//             select = ons + nums[i];
//             non_select = Math.max(os, ons);
//         }
//         ret = Math.max(ret, Math.max(select, non_select));
        
//         return ret;
        
        int[] first = Arrays.copyOfRange(nums, 0, nums.length-1);
        int[] second = Arrays.copyOfRange(nums, 1, nums.length);
        return Math.max(robDp(first), robDp(second));
    }
    
    public int robDp(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // last house status
        int N = nums.length;
        int select = 0;
        int non_select = 0;
        for (int i = 0; i < nums.length; i++) {
            int os = select, ons = non_select;
            select = ons + nums[i];
            non_select = Math.max(os, ons);
        }
        return Math.max(select, non_select);
    }
}
