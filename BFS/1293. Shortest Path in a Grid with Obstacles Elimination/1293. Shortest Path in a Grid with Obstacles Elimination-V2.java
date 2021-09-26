class Solution {
    boolean[][][] visited = new boolean[40][40][1601];
    public int shortestPath(int[][] grid, int k) {
         // three status with x, y, and k
        int m = grid.length, n = grid[0].length;
        if (m == 1 && n == 1) return 0;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0, 0});
        visited[0][0][0] = true;
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                int s = cur[2];
                
                for (int j = 0; j < 4; j++) {
                    int cx = x + dirs[j][0];
                    int cy = y + dirs[j][1];
                    if (cx == m-1 && cy == n-1) return step+1;
                    
                    if (cx < 0 || cx >= m || cy < 0 || cy >= n) continue;
                    
                    if (grid[cx][cy] == 1) {
                        if (s == k) continue;
                        if (visited[cx][cy][s+1]) continue;
                        visited[cx][cy][s+1] = true;
                        q.offer(new int[] {cx, cy, s+1});
                    } else {
                        if (visited[cx][cy][s]) continue;
                        visited[cx][cy][s] = true;
                        q.offer(new int[] {cx, cy, s});
                    }
                }
            }
            
            
            step++;
        }
        return -1;
    }
}
