class Solution {
    public int[] decode(int[] encoded) {
        int n = encoded.length+1;
        int x = 0;
        for (int i = 1; i <= n; i++) {
            x ^= i;
        }
        
        int[] rets = new int[n];
        for (int i = 1; i <= n-2; i += 2) {
            x ^= encoded[i];
        }
        rets[0] = x;
        for (int i = 1; i < n; i++) {
            rets[i] = rets[i-1]^encoded[i-1];
        }
        return rets;
    }
}

// 0 p1 p2 p3 p4 ......  pn
// 0  e1  e2 e3 e4.....en-1

// x = p1^p2^p3^p4.......^pn (n odd)
// e0 = 0
// e1 = p1^p2
// e2 = p2^p3
// e3 = p3^p4
// e4 = p4^p5
// e5 = p5^p6
// .....
// en-1 = pn-1^pn

// x = p1^[p2^p3^p4.......^pn]
// p1 = x^(e2^e4^e6......^en-1) => p0^e0 => p0 = x^(e2^e4^e6......^en-1)
// p2 = p1^e1
// p3 = p2^e2
