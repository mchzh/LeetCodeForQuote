class Solution {
    public int maximumXorProduct(long a, long b, int n) {
        long A = (a>>n);
        long B = (b>>n);
        if (A < B) return maximumXorProduct(b, a, n);
        // from highest pos to low
        long mod = (long)(1e9+7);
        long one = (long)1;
        
        if (A > B) {
            for (int i = n-1; i >= 0; i--) {
                long bit1 = (one<<i)&a, bit2 = (one<<i)&b;
                if (bit1 == bit2) {
                    // a and b is '1' on i pos
                    a = (a-bit1+(one<<i));
                    b = (b-bit2+(one<<i));
                } else {
                    //a 0 b 1 because A > B
                    a = (a-bit1);
                    b = (b-bit2+(one<<i));
                }
            }
        } else {
            // A== B
            int flag = 0;
            for (int i = n-1; i >= 0; i--) {
                long bit1 = (one<<i)&a, bit2 = (one<<i)&b;
                if (bit1 == bit2) {
                    // a and b is '1' on i pos
                    a = (a-bit1+(one<<i));
                    b = (b-bit2+(one<<i));
                } else {
                    //first a 1 b 0 i pos
                    // floow b 1 a 0 i pos
                    if (flag == 0) {
                        a = (a-bit1+(one<<i));
                        b = (b-bit2);
                        flag = 1;
                    } else {
                        a = (a-bit1);
                        b = (b-bit2+(one<<i));
                    }
                }
            }
        }
        //System.out.println(a + " : " + b);
        

        return (int)((a%mod)*(b%mod)%mod);
    }
}

// a:    0          1
// b:    1          1
// x:   0 1        0  1
// re:  0/1 1/0     1
