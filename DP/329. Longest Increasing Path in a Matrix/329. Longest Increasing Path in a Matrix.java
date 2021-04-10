class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int rets = 0;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                rets = Math.max(rets, dfs(matrix, i, j, memo));
            }
        }
        return rets;
    }
    private int dfs(int[][] a, int x, int y, int[][] memo) {
        if (memo[x][y] != 0) return memo[x][y];
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        //int ret = 0;
        for (int k = 0; k < 4; k++) {
            int cx = x + dirs[k][0];
            int cy = y + dirs[k][1];
            if (cx < 0 || cx >= a.length) continue;
            if (cy < 0 || cy >= a[0].length) continue;
            if (a[cx][cy] <= a[x][y]) continue;
            memo[x][y] = Math.max(memo[x][y], dfs(a, cx, cy, memo));
        }
        memo[x][y] += 1;
        return memo[x][y];
    }
}
