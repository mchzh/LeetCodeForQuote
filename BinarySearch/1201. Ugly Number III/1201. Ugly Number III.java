class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long left = 1, right = Integer.MAX_VALUE;
        while (left < right) {
            long mid = left + (right-left)/2;
            if (count(mid, a, b, c) < n) {
                left = mid+1;
            } else right = mid;
        }
        return (int)left;
    }
    // Principle of inclusion-exclusion(容斥原理)
    // n/a + n/b + n/c - n/lcm(a*b) - n/lcm(b*c) - n/lcm(a*c) + n/lcm(a*b*c)
    private long count(long m, long a, long b, long c) {
        return m/a + m/b + m/c - m/lcm(a, b) - m/lcm(b, c) - m/lcm(a, c) + m/lcm(a, lcm(b,c));
    }
    private long lcm(long a, long b) {
        return a*b/gcd(a,b);
    }
    private long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }
}
