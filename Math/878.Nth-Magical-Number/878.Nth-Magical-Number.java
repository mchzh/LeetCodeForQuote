class Solution {
    // do it with 1201 Ugly Number III
    // binary search or period
    public int nthMagicalNumber(int N, int A, int B) {
        int MOD = 1000000007;
        long lcm = (long)lcm(A, B);
        long unitMagic = lcm/A + lcm/B -1;
        long p = (long)N/unitMagic;
        long t = (long)(N - p*unitMagic);
        
        if (t == 0) return (int)((p*lcm)%MOD);
        
        long count = 0;
        int i = 1, j = 1;
        long remainder = 0;
        while (count < t) {
            if (A*i < B*j) {
                remainder = A*i;
                i++;
            } else {
                remainder = B*j;
                j++;
            }
            count++;
        }
        
        return (int)(((p*lcm)%MOD + remainder)%MOD);
    }
    private int gcd(int p, int q) {
        if (q == 0) return p;
        
        return gcd(q, p%q);
    }
    
    private int lcm(int p, int q) {
        return (p*q)/gcd(p,q);
    }
}

// lcm(2, 3) magical number is 4 => 6/2 + 6/3 -1
// every lcm distance is a period
// restNum = N - k*period 0 ? lcm * num : lcm * num + remainder

/*class Solution {
    public int nthMagicalNumber(int N, int A, int B) {
        int MODULES = 1_000_000_007;
        long l = 0, r = 1_000_000_000L * 40_000L;
        while (l < r) {
            long m = (r - l) / 2 + l;
            if (enough(A, B, N, m))
                r = m;
            else 
                l = m + 1;
        }
        return (int) (l % MODULES);
    }

    private boolean enough(int a, int b, int n, long x) {
        return x / a + x / b - x / lcm(a, b) >= n;
    }

    private int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    private int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}*/
