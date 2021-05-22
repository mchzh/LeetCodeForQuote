class Solution {
    public boolean xorGame(int[] nums) {
        int xorsum = 0;
        for (int n : nums) xorsum ^= n;
        if (xorsum == 0) return true;
        return nums.length%2 == 0;
    }
}
