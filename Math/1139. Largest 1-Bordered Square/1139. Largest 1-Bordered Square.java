class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int[][] row = new int[m][n+1];
        int[][] col = new int[m+1][n];
        
        // record the prefix for one numbers
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int add = grid[i][j] == 1 ? 1 : 0;
                row[i][j+1] = row[i][j] + add;
                col[i+1][j] = col[i][j] + add;
            }
        }
        
        int ret = 0;
        // O(N3) ensure every square
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //i,j is left-top start point and len
                int len = Math.min(m-i, n-j);
                for (int k = 1; k <= len; k++) {
                    // make sure the rest of three vertex and get 1's num of every border
                    int top = row[i][j+k]-row[i][j];
                    if (top != k) continue;
                    int left = col[i+k][j]-col[i][j];
                    if (left != k) continue;
                    int bottom = row[i+k-1][j+k]-row[i+k-1][j];
                    if (bottom != k) continue;
                    int right = col[i+k][j+k-1]-col[i][j+k-1];
                    if (right != k) continue;
                    ret = Math.max(ret, k*k);
                }
            }
        }
        return ret;
    }
}

/*class Solution {
    public int largest1BorderedSquare(int[][] A) {
        int m = A.length, n = A[0].length;
        int[][] left = new int[m][n], top = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (A[i][j] > 0) {
                    left[i][j] = j > 0 ? left[i][j - 1] + 1 : 1;
                    top[i][j] = i > 0  ? top[i - 1][j] + 1 : 1;
                }
            }
        }
        for (int l = Math.min(m, n); l > 0; --l)
            for (int i = 0; i < m - l + 1; ++i)
                for (int j = 0; j < n - l + 1; ++j)
                    if (top[i + l - 1][j] >= l &&
                            top[i + l - 1][j + l - 1] >= l &&
                            left[i][j + l - 1] >= l &&
                            left[i + l - 1][j + l - 1] >= l)
                        return l * l;
        return 0;
    }
}*/

// 1 1 1 1 1 1
// X X X X X X
// Y Y Y Y Y Y
// prefixrow[i][j] = prefixrow[i][j-1] + 1:0
// prefixcol[i][j] = prefixcol[i-1][j] + 1:0
