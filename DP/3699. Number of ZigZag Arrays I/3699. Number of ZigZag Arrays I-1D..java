class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int m = r-l+1;
        long[] up = new long[m+1];
        long[] down = new long[m+1];
        long mod = (long)(1e9+7);
        Arrays.fill(up, (long)1);
        Arrays.fill(down, (long)1);

        for (int i = 2; i <= n; i++) {
            long presum = 0;
            long[] new_up = new long[m+1];
            for (int x = 1; x <= m; x++) {
                new_up[x] = presum;
                presum = (presum+down[x])%mod;
            }
            presum = 0;
            long[] new_down = new long[m+1];
            for (int x = m; x >= 0; x--) {
                new_down[x] = presum;
                presum = presum+up[x];
            }

            up = Arrays.copyOf(new_up, m+1);
            down = Arrays.copyOf(new_down, m+1);
        }

        long rets = 0;
        for (int x = 1; x <= m; x++) {
            rets += up[x];
            rets += down[x];
            rets %= mod;
        }
        return (int)rets;
    }
}

// x x  x  x x 
//     i-1 i
// up[i][x]: i pos, x element, last trend is up
// down[i][x]: i pos, x elment, last trend is down

// up[i][x] = sum(down[i-1][y])  y = 0, 1, ...., x-1  
// down[i][x] = sum(up[i-1][y]) y = x+1, ..., m
// m = r-l+1;
// i depend i-1 can use two aarrs : old and new
