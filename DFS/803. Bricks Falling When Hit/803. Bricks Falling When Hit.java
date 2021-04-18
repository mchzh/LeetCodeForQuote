class Solution {
    int[][] dirs = {{1,0}, {-1, 0}, {0,1}, {0,-1}};
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int m = grid.length, n = grid[0].length;
        for (int[] h : hits) {
            grid[h[0]][h[1]] *= -1;
        }
        // seperate the stable connection and unstable part
        //int count = 0;
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1) {
                dfs(grid, 0, j);
            }
        }
        
        int[] rets = new int[hits.length];
        for (int i = hits.length-1; i >= 0; i--) {
            rets[i] = 0;
            int x = hits[i][0], y = hits[i][1];
            if (grid[x][y] != -1) {
                continue;
            }
            boolean connectCeiling = (x==0);
            for (int k = 0; k < 4; k++) {
                int cx = x + dirs[k][0];
                int cy = y + dirs[k][1];
                if (cx < 0 || cx >= grid.length) continue;
                if (cy < 0 || cy >= grid[0].length) continue;
                if (grid[cx][cy] == 2) {
                    connectCeiling = true; 
                    break;
                }      
            }
            if (connectCeiling) {
                rets[i] = dfs(grid, hits[i][0], hits[i][1])-1;
            } else {
                grid[x][y] = 1;
            }
        }
        return rets;
    }
    private int dfs(int[][] grid, int x, int y) {
        grid[x][y] = 2;
        
        int rets = 1;
        for (int k = 0; k < 4; k++) {
            int cx = x + dirs[k][0];
            int cy = y + dirs[k][1];
            if (cx < 0 || cx >= grid.length) continue;
            if (cy < 0 || cy >= grid[0].length) continue;
            if (grid[cx][cy] != 1) continue;
            rets += dfs(grid, cx, cy);
        }
        return rets;
    }
}
