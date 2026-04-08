class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {
        // fix length to get all val with two pointer
        Map<Integer, int[]> map = new HashMap<>(); // val -> idx(left most)
        for (int l = 1;  l <= Math.min(s.length(), 30); l++) {
            int mask = 1;
            int midx = 0;
            while (midx < l) {
                mask <<= 1;
                midx++;
            }
            mask -= 1;
            
            int val = 0;
            int right = 0;
            for (int i = 0; i < s.length()-l+1; i++) {
                // remove left most digit and add current right digit
                while (right < l-1) {
                    val <<= 1;
                    val += (s.charAt(right) == '0' ? 0 : 1);
                    right++;
                }
                
                val <<= 1;
                val &= mask;
                val += (s.charAt(right) == '0' ? 0 : 1);
                if (!map.containsKey(val)) {
                    map.put(val, new int[]{i, i+l-1});
                }
                right++;
            }
        }

        int n = queries.length;
        int[][] rets = new int[n][2];
        for (int i = 0; i < n; i++) {
            int[] q = queries[i];
            int tar = q[0] ^ q[1];
            
            if (map.containsKey(tar)) {
                int[] idxs = map.get(tar);
                rets[i][0] = idxs[0];
                rets[i][1] = idxs[1];
            } else {
                rets[i][0] = -1;
                rets[i][1] = -1;
            }
        }
        return rets;
    }
}
// a^b = c
// === (a^b) ^ c = 0 => a^(b^c) = 0
// a = (b^c)
