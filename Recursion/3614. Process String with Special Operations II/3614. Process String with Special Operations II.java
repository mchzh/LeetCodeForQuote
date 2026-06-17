class Solution {
    // trie or segment tree
    // digit count and recursion
    // current round k is able to get the last round k position
    public char processStr(String s, long k) {
        k++;
        s = "&" + s;
        int n = s.length();
        long[] len = new long[n];
        // get the len for every round
        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
           
            if (c >= 'a' && c <= 'z') {
                len[i] = len[i-1] + 1;
            } else if (c == '*') {
                len[i] = (len[i-1] == 0) ? 0 : len[i-1] - 1;
            } else if (c == '#') {
                len[i] = 2*len[i-1];
            } else if (c == '%') {
                // reverse :decide prev kk postion
                len[i] = len[i-1];
            }
        }
        // for (int i = 1; i < n; i++) {
        //     System.out.println(i + " : " + len[i]);
        // }
        // System.out.println(len[n-1]);
        //System.out.println(k + " : " + (k > len[n-1] || k == 0));
        if (k > len[n-1] || k == 0) return '.';

        // from right to left go every round
        for (int t = n-1; t>0;t--) {
            char c = s.charAt(t);
            long before = len[t-1];
            long after = len[t];
            // f(t, k) = f(t,kk)
            if (c >= 'a' && c <= 'z') {
                if (k == after) return c;
            } else if (c == '*') {
                k = k;
            } else if (c == '#') {
                if (k > before) {
                    k -= before;
                }
            } else if (c == '%') {
                // reverse :decide prev kk postion
                k = before+1-k;
            }
        }

        return '.';
    }
}
// double: f[t, k] = f(t-1, k-l)
