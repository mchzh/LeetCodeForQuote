class Solution {
    public int[] singleNumber(int[] nums) {
        int xorwithtwo = 0;
        for (int a : nums) {
            xorwithtwo ^= a;
        }
        // just keep the rightmost 1 bit
        int compare = xorwithtwo^(xorwithtwo&(xorwithtwo-1));
        // loop the original array to divide two type list number
        int a = 0, b = 0;
        for (int x : nums) {
            if ((x&compare) != 0) {
                // has 1 value under the rightmost 1 bit pos: 1&1 = 1
                a ^= x;
            } else {
                b ^= x;
            }
        }
        return new int[]{a, b};
    }
}
