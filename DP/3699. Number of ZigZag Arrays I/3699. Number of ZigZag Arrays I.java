class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int m = r-l+1;
        long[][] up = new long[n+1][m+1];
        long[][] down = new long[n+1][m+1];
        long mod = (long)(1e9+7);
        for (long[] u : up) {
            Arrays.fill(u, (long)1);
        }
        for (long[] d : down) {
            Arrays.fill(d, (long)1);
        }

        for (int i = 2; i <= n; i++) {
            long presum = 0;
            for (int x = 1; x <= m; x++) {
                up[i][x] = presum;
                presum = (presum+down[i-1][x])%mod;
            }
            presum = 0;
            for (int x = m; x >= 0; x--) {
                down[i][x] = presum;
                presum = presum+up[i-1][x];
            }
        }

        long rets = 0;
        for (int x = 1; x <= m; x++) {
            rets += up[n][x];
            rets += down[n][x];
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
