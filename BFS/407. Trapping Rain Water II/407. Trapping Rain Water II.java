class Solution {
    public int trapRainWater(int[][] heightMap) {
        // bfs + pq : sea line and inner lake
        int m = heightMap.length, n = heightMap[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0])); // h, x, y
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++)
                if (i == 0 || i == m-1 || j == 0 || j == n-1) pq.offer(new int[] {heightMap[i][j], i, j});
        
        int curh = Integer.MIN_VALUE;
        int rets = 0;
        int[][] dirs = {{-1, 0},{1, 0},{0, 1},{0, -1}};
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int h = cur[0];
            int x = cur[1];
            int y = cur[2];
            if (visited[x][y]) continue;
            visited[x][y] = true;
            if (h > curh) curh = h;
        
            rets += curh-h;
            for (int k = 0; k < 4; k++) {
                int cx = x + dirs[k][0];
                int cy = y + dirs[k][1];
                if (cx < 0 || cx >= m || cy < 0 || cy >= n) continue;
                if (visited[cx][cy]) continue;
                pq.offer(new int[] {heightMap[cx][cy], cx, cy});
            }
        }
        return rets;
    }
}
