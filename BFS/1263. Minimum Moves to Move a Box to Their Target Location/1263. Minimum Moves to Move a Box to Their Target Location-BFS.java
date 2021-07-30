class Solution {
    // bfs + deque
    public int minPushBox(char[][] grid) {
        int bx=0, by=0, px=0, py=0, tx=0, ty=0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'S') {
                    px = i;
                    py = j;
                    grid[i][j] = '.';
                } else if (grid[i][j] == 'T') {
                    tx = i;
                    ty = j;
                    grid[i][j] = '.';
                } else if (grid[i][j] == 'B') {
                    bx = i;
                    by = j;
                    grid[i][j] = '.';
                }
            }
        }
        
        Deque<int[]> q = new LinkedList<>();
        int[][][][] level = new int[21][21][21][21];
        q.offer(new int[] {bx, by, px, py});
        level[bx][by][px][py] = 1;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            bx = cur[0]; 
            by = cur[1]; 
            px = cur[2]; 
            py = cur[3];
            //System.out.println(bx + " " + by + " " +  px + " " + py);
            if (bx == tx && by == ty) return level[bx][by][px][py]-1;
            
            // only person move
            for (int k = 0; k < 4; k++) {
                int x = px + dirs[k][0];
                int y = py + dirs[k][1];
                if (x < 0 || x >= m || y < 0 || y >= n) continue;
                
                if (grid[x][y] != '.') continue;
                if (x == bx && y == by) continue;
                if (level[bx][by][x][y] > 0) continue;
                level[bx][by][x][y] = level[bx][by][px][py];
                q.offerFirst(new int[] {bx, by, x, y});
            }
            
            // move the person and box with neighbour
            if (Math.abs(px-bx) + Math.abs(py-by) == 1) {
                for (int k = 0; k < 4; k++) { 
                    if ( px+dirs[k][0] == bx && py+dirs[k][1] == by) { // on same direction to push
                        int bx2 = bx + dirs[k][0];
                        int by2 = by + dirs[k][1];
                        if (bx2 < 0 || bx2 >= m || by2 < 0 || by2 >= n) continue;
                        if (grid[bx2][by2] != '.') continue;
                        if (level[bx2][by2][bx][by] > 0) continue;
                        level[bx2][by2][bx][by] = level[bx][by][px][py]+1;
                        q.offerLast(new int[] {bx2, by2, bx, by});
                    }
                    
                }
            }
        }
        return -1;
    }
}
// [bx, by, px, py]
