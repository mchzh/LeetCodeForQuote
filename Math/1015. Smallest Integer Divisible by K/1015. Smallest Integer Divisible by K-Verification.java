class Solution {
   /* 这个题有点不好想，如果不去考虑技巧的话，根本想不出来还有什么解法。

首先，如果K的尾数是2，4，5，6，8的话，一定不存在N。简单说明：我们要求的N结尾一定是1，那么一定不能被2的倍数整除。另外我们知道能被5整除的数字的结尾必须是0或者5，所以得证。

然后，我们要证明N的长度不会超过K。

我们要判断对于每个N其对K的余数：1 % K, 11 % K, 111 % K, ..., 11...1 (K '1's) % K.

如果这K个余数中有一个余数是0，那么当前的N能被K整除直接返回。
如果这K个余数中都不为0时，一定有重复的余数！我们知道一个数对K的余数只能是0 ~ K - 1其中的一个，所以如果K个数字的余数中没有0，那么肯定有重复的余数。如果出现重复的余数，那么后面再增大N时，对K的余数就会形成循环，则再也不可能出现余数为0的情况。
总之，如果遍历到了长度为K的N时仍然不存在余数是0，那么后面就不用搜索了。

举个例子，我们发现长度 <= 6 = K的N的余数是循环的。

1 % 6 = 1
11 % 6 = 5
111 % 6 = 3
1111 % 6 = 1
11111 % 6 = 5
111111 % 6 = 3
严谨的证明应该是如果N2 % K == N1 % K的话，证明(10 * N2 + 1) % K == (10 * N1 + 1) % K. 留给读者证明吧。

另外，我们在求的过程中，并不是直接维护的N，而是维护的N % K，这里的假设是(10 * N + 1) % K的变化规律和(10 * (N % K) + 1) % K变化规律一致。*/

    // https://leetcode.com/problems/smallest-integer-divisible-by-k/discuss/275896/java-1ms-modular-solution-with-explanation
    //https://leetcode.com/problems/smallest-integer-divisible-by-k/discuss/261805/Very-short-and-clear-explanation-O(K)-(also-2-linesJavaC%2B%2BCJavaScriptPHP).
    public int smallestRepunitDivByK(int K) {
        // the length of N no more than K
        if (K % 2 == 0 || K % 5 == 0) return -1;
        for (int i = 0, a=0; i < K; i++) {
            a = (a*10+1) % K;
            if (a == 0) return i+1;
        }
        /*long cur = 0;
        int len = 0;
        while (cur*10 + 1 <= Long.MAX_VALUE) {
            len++;
            cur = cur*10 + 1;
            if (cur % K == 0) return len;
        }*/
        return -1;
    }
}
