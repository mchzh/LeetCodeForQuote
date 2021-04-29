class Solution {
    public int singleNumber(int[] nums) {
        int bits1 = 0, bits2 = 0;
        for (int cur : nums) {
            int bits1_new = 0, bits2_new = 0;
            for (int i = 0; i < 32; i++) {
                int hi = ((bits1>>i)&1);
                int lo = ((bits2>>i)&1);
                int sum = (hi*2+lo+((cur>>i)&1))%3;
                bits1_new += ((sum/2)<<i);
                bits2_new += ((sum%2)<<i);
            }
            bits1 = bits1_new;
            bits2 = bits2_new;
        }
        int rets = 0;
        for (int i = 0; i < 32; i++) {
            rets += (((bits2>>i)&1)<<i);
        }
        return rets;
    }
}
