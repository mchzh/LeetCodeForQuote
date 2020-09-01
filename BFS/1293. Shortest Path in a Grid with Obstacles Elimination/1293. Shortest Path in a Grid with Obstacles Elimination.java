class Solution {
    // bfs(x, y, r)
    public int shortestPath(int[][] grid, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>( (a, b) -> (b[2] - a[2]) );
        int row = grid.length, col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        if (grid[0][0] == 1) {
            if (k== 0) return -1;
            else queue.offer(new int[] {0, 0, k-1});
        } else {
            queue.offer(new int[] {0, 0, k});
        }
        visited[0][0] = true; 
        
        int level = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0,-1}};
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (cur[0] == row-1 && cur[1] == col-1) return level-1;
                for (int l = 0; l < dirs.length; l++) {
                    
                    int cx = cur[0] + dirs[l][0];
                    int cy = cur[1] + dirs[l][1];
                    
                    if (cx < 0 || cx >= row || cy < 0 || cy >= col) continue;
                    if (cx == row-1 && cy == col-1 && grid[cx][cy] == 0) return level;
                    if (visited[cx][cy]) continue;
                    // two situation
                    // current element is 1, and remain k less than 0
                    // last element is 1, and current remain k is 0
                    if (grid[cx][cy] == 1 && cur[2]-1 < 0) continue;
                    if (grid[cur[0]][cur[1]] == 1 && cur[2] == 0) continue;
                    int r = grid[cx][cy] == 1 ? cur[2]-1 : cur[2]; 
                    list.add(new int[] {cx, cy, r});
                    visited[cx][cy] = true;
                }
            }
            
            // next level
            for (int[] x : list) {
                queue.offer(x);
            }
        }
        return -1;
    }
}
