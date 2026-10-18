class Solution {
      // // C(a, b) = C(a-1, b) + (a-1, b-1)
      long[][] comb = new long[1001][1001];
    public long getComb(int m, int n) {
        if (comb[m][n] != 0L) {
            return comb[m][n];
        }
        // C(5,2) =C(5,3)
        if (n > m-n) {
            return getComb(m, m-n);
        }

        if (n == 0L) {
            return 1L;
        }
        if (n == 1L) {
            return m;
        }

        long a = getComb(m-1, n);
        long b = getComb(m-1, n-1);
        comb[m][n] = (a + b)%mod;
        return comb[m][n];
    }
}

// c(n,1) + c(n,3) +... = 2^(n-1)
