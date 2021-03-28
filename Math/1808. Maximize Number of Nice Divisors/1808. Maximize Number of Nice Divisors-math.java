class Solution {
    // https://leetcode.com/problems/integer-break/  (343 Integer break)
    // most 2 of 32
    // https://leetcode.com/problems/maximize-number-of-nice-divisors/discuss/1130495/Python-O(log-n)-math-solution-explained
    // given a1+a2+....ak <= n, find max a1*a2*....*ak
    // https://leetcode.com/problems/maximize-number-of-nice-divisors/discuss/1130621/Java-Time%3A-O(logN)-Space%3A-O(1).-Brief-thinking-process.
    public int maxNiceDivisors(int primeFactors) {
        long mod = (long)(1e9+7);
        long n = primeFactors;
        if (n <= 3) return (int)n;
        if (n%3 == 0) return (int)(powWith32(3, n/3, mod)%mod);
        else if (n%3 == 1) return (int) ((powWith32(3,(n-4)/3, mod)*4)%mod);
        else return (int) ((powWith32(3,n/3, mod)*2)%mod);
    }
    public long powWith32(long m, long n, long mod) {
        if (n == 1) return m;
        if (n == 0) return 1;
        long cur = powWith32(m, n/2, mod);
        //long rets = 1;
        if (n%2 == 0) {
            return (cur*cur)%mod;
        } else {
            return (cur*cur*m)%mod;
        }
        
    }
}
