class Solution {
    // greedy
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length, n = colSum.length;
        int[][] rets = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int v = Math.min(rowSum[i], colSum[j]);
                rets[i][j] = v;
                rowSum[i] -= v;
                colSum[j] -= v;
            }
        }
        return rets;
    }
}

// X X X a
// X X X b
// X X X c

// x y z

// x+y+z = a+b+c => a <= x+y+z
// g[0,0] : min(x, a);
// g[0,1] : min(y, a-g[0,0]);
// g[0,2] : min(z, a-g[0,0]-g[0,1]);


// O O O a
// X X X b
// X X X c

// x' y' z'

// x+y+z-a = b+c
// x'+y'+z' = b+c => b <= x'+y'+z'
// g[1,0] : min(x', b);
// g[1,1] : min(y', b-g[1,0]);
// g[1,2] : min(z', b-g[1,0]-g[1,1]);

// O O O a
// O O O b
// X X X c

// x* y* z*

// x'+y'+z'-b = c
// x*+y*+z* = c
