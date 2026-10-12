class Solution {
    public int maxSum(List<Integer> nums, int k) {
        long mod = (long)(1e9+7);
        int[] count = new int[32];
        for (int x : nums) {
            for (int i = 0; i < 32; i++) {
                if ( ((x>>i)&1) == 1) {
                    count[i]++;
                }
            }
        }
        // get the first k element
        long ret = 0;
        for (int t = 0; t < k; t++) {
            long x = 0;
            for (int i = 31; i >= 0; i--) {
                if (count[i] > 0) {
                    x += (1L<<i);
                    count[i]--;
                }
            }
            x %= mod;
            ret += (x*x) % mod;
            ret %= mod;
        }
        return (int)ret;
    }
}

// X Y = AND OR
// 1 1    1   1
// 1 0    0   1
// 0 1    0   1
// 0 0    0   0

// X + Y = AND + OR
//         reduce add(move 1)

// zero - sum
// x^2 + y^2 < (x+d)^2 + (y-d)^2

// when x > y and d > 0
//            = x^2 + y^2 + 2*(x-y)*d + 2*d^2
//  X X X X X X X x
//  1 1 0 1 1 1 0 1
//  1 0 0 1 1 1 0 1
