class Solution {
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for (int cur : nums) {
            for (int i = 0; i < 32; i++) {
                bits[i] += ((cur>>i)&1);
            }
        }
        int rets = 0;
        for (int i = 0; i < 32; i++) {
            rets += ((bits[i]%3)<<i);
        }
        return rets;
    }
}
