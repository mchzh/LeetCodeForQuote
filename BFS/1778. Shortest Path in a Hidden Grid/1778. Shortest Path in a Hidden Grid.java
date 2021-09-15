/**
 * // This is the GridMaster's API interface.
 * // You should not implement it, or speculate about its implementation
 * class GridMaster {
 *     boolean canMove(char direction);
 *     void move(char direction);
 *     boolean isTarget();
 * }
 */

class Solution {
    int[][] grid = new int[1001][1001];
    boolean[][] visited = new boolean[1001][1001];
    GridMaster master = null;
    boolean hasTarget = false;
    
    public int findShortestPath(GridMaster master) {
        this.master = master;
        int N = 500;
        dfs(N, N);
        if (!hasTarget) return -1;
        // bfs to find the shorted path
        for (boolean[] v : visited) Arrays.fill(v, false);
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {N, N});
        visited[N][N] = true;
        
        int level = 0;
        while (!q.isEmpty()) {
            
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                if (grid[x][y] == 2) return level;
                
                int[][] dirs = {{-1, 0}, {1, 0}, {0, -1},{0, 1}}; // U D L R
                for (int k = 0; k < 4; k++) {
                    int cx = x + dirs[k][0];
                    int cy = y + dirs[k][1];
                    if (cx <0 || cx >= 1001 || cy < 0 || cy >= 1001) continue;
                    if (visited[cx][cy]) continue;
                    if (grid[cx][cy] == 0) continue;
                    
                    q.offer(new int[] {cx, cy});
                    visited[cx][cy] = true;
                }
            }
            level++;
        }
        return -1;
    }
    
    
    private void dfs(int x, int y) {
        if (master.isTarget()) {
            grid[x][y] = 2;
            hasTarget = true;
            return;
        }
        
        grid[x][y] = 1;
        visited[x][y] = true;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1},{0, 1}}; // U D L R
        char[] forward = {'U','D','L','R'};
        char[] backward = {'D','U','R','L'};
        for (int k = 0; k < 4; k++) {
            int cx = x + dirs[k][0];
            int cy = y + dirs[k][1];
            if (visited[cx][cy]) continue;
            
            if (!master.canMove(forward[k])) {
                //grid[cx][cy] = ;
                continue;
            } else {
                master.move(forward[k]);
                dfs(cx, cy);
                master.move(backward[k]);
            }
        }
    }
}
