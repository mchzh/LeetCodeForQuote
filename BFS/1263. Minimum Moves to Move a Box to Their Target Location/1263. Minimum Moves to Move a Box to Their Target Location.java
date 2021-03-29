class Solution {
    public int minPushBox(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int bx1 = -1, by1 = -1, px1 = -1, py1 = -1, tx = -1, ty = -1;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'S') {
                    px1 = i; py1 = j;
                    grid[i][j] = '.';
                } else if (grid[i][j] == 'B') {
                    bx1 = i; by1 = j;
                    grid[i][j] = '.';
                } else if (grid[i][j] == 'T') {
                    tx = i; ty = j;
                    //grid[i][j] = '.';
                }
            }
        }
        
        Deque<int[]> q = new LinkedList<>();
        int[][][][] memo = new int[21][21][21][21];
        setmemoinit(memo);
        memo[bx1][by1][px1][py1] = 0;
        q.offerFirst(new int[] {bx1, by1, px1, py1});
        
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();
            int bx = cur[0], by = cur[1], px = cur[2], py = cur[3];
            if (bx == tx && by == ty) return memo[bx][by][px][py];
            // box not move
            for (int k= 0; k < 4; k++) {
                int x = px + dirs[k][0];
                int y = py + dirs[k][1];
                if (x < 0 || x >= m) continue;
                if (y < 0 || y >= n) continue;
                if (grid[x][y] == '#') continue;
                if (x == bx && y == by) continue;
                if (memo[bx][by][x][y] >= 0) continue;
                
                memo[bx][by][x][y] = memo[bx][by][px][py];
                q.offerFirst(new int[] {bx, by, x, y});
            }
            // person and box stick together
            if (Math.abs(px-bx) + Math.abs(py-by) == 1) {
                for (int k= 0; k < 4; k++) {
                    if (px + dirs[k][0] == bx && py + dirs[k][1] == by) {
                        int bx2 = bx + dirs[k][0];
                        int by2 = by + dirs[k][1];
                        if (bx2 < 0 || bx2 >= m) continue;
                        if (by2 < 0 || by2 >= n) continue;
                        if (grid[bx2][by2] == '#') continue;
                        //if (x == bx && y == by) continue;
                        if (memo[bx2][by2][bx][by] >= 0) continue;
                        memo[bx2][by2][bx][by] = memo[bx][by][px][py] + 1;
                        q.offerLast(new int[] {bx2, by2, bx, by});
                    }
                }
            }
        }
        
        return -1;
    }
    private void setmemoinit(int[][][][] memo) {
        for (int i= 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                for (int k = 0; k < 21; k++) {
                    Arrays.fill(memo[i][j][k], -1);
                }
            }
        }
    }
}

// [bx, by, px, py]:
// box stay
// [bx, by, px-1, py], [bx, by, px+1, py] ......
// [bx-1, by, px-1, py], [bx+1, by, px+1, py] .... neighbor and move together
