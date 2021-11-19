class Solution {
    public int integerReplacement(int n) {
        int level = 0;
        while (n != 1) {
            if ( (n&1) == 0 ) {
                n >>>= 1;
            } else if (n == 3 || Integer.bitCount(n+1) > Integer.bitCount(n-1)) { // forward and backward both is even
                --n;
            } else {
                ++n; // for example: 8 vs 6 (7+1 <-> 7-1)
            }
            ++level;
        }
        return level;
    }
}
