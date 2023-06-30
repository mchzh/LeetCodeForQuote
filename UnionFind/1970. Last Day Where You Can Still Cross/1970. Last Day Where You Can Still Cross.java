class Solution {
    // 1. binary serch + BFS
    // 2. Union find + time reversal + virtual node top and bottom
    int[] Father;
    // unionfind two basic function
    private void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x < y) {
            Father[y] = x;
        } else {
            Father[x] = y;
        }
    }
    private int find(int x) {
        if (Father[x] != x) {
            Father[x] = find(Father[x]);
        }
        return Father[x];
    }

    public int latestDayToCross(int row, int col, int[][] cells) {
        int m = row, n = col;
        Father = new int[m*n+2];
        // initialize
        for (int i = 0; i < m*n+2; i++) {
            Father[i] = i;
        }
        // top virtual node to connect all first row element
        for (int j = 0; j < n; j++) union(j, m*n);
        // bottom virtual node to connect all first row element
        for (int j = 0; j < n; j++) union((m-1)*n+j, m*n+1);

        // set the initialized connection
        int[][] matrix = new int[m][n];
        for (int[] c : cells) {
            int x= c[0]-1, y = c[1]-1;
            matrix[x][y] = 1;
        }
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) continue;

                // four direction neighbor
                for (int k = 0; k < 4; k++) {
                    int x = i + dirs[k][0];
                    int y = j + dirs[k][1];

                    if (x < 0 || x >= m || y < 0 || y >= n) continue;
                    if (matrix[x][y] == 1) continue;

                    if (find(i*n+j) != find(x*n+y)) {
                        union(i*n+j, x*n+y);
                    }
                }
            }
        }

        // from right most endpoint go backforward to leftmost step by step
        int days = cells.length;
        for (int t = days-1; t >= 0; t--) {
            // if checkok (top <-> bottom) return t+1
            if (find(m*n) == find(m*n+1)) return t + 1;
            int x = cells[t][0]-1, y = cells[t][1]-1;
            matrix[x][y] = 0;
            // for the new zero, to find four direction
            for (int k = 0; k < 4; k++) {
                int cx = x + dirs[k][0];
                int cy = y + dirs[k][1];

                if (cx < 0 || cx >= m || cy < 0 || cy >= n) continue;
                if (matrix[cx][cy] == 1) continue;

                if (find(cx*n+cy) != find(x*n+y)) {
                    union(cx*n+cy, x*n+y);
                }
            }
        }
        return -1;
    }
}
