class Solution {
    public String optimalDivision(int[] nums) {
        if (nums.length == 1) return String.valueOf(nums[0]);
        if (nums.length == 2) return String.valueOf(nums[0])+ "/" + String.valueOf(nums[1]);
        String rets = "";
        rets += String.valueOf(nums[0])+ "/(";
        for (int i = 1; i < nums.length; i++) {
            rets += String.valueOf(nums[i]) + ((i == (nums.length-1)) ?  "" : "/");
        }
        rets += ")";
        return rets;
    }
}
