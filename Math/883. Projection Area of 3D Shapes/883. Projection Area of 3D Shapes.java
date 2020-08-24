class Solution {
    public int projectionArea(int[][] grid) {
        int N = grid.length;
        int ans = 0;

        for (int i = 0; i < N;  ++i) {
            int bestRow = 0;  // largest of grid[i][j]
            int bestCol = 0;  // largest of grid[j][i]
            for (int j = 0; j < N; ++j) {
                if (grid[i][j] > 0) ans++;  // top shadow
                bestRow = Math.max(bestRow, grid[i][j]);
                bestCol = Math.max(bestCol, grid[j][i]);
            }
            ans += bestRow + bestCol;
        }

        return ans;
        // int m = grid.length, n = grid[0].length;
        // int ret = 0;
        // int[] row = new int[m];
        // int[] col = new int[n];
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (grid[i][j] > 0) ret++;
        //         row[i] = Math.max(row[i], grid[i][j]);
        //         col[j] = Math.max(col[j], grid[i][j]);
        //     }
        // }
        // for (int i = 0; i < m; i++) ret += row[i];
        // for (int j = 0; j < n; j++) ret += col[j];
        // return ret;
    }
}
