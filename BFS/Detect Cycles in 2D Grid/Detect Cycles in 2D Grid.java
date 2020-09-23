class Solution {
    public boolean containsCycle(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        
        // tranverse
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == true) continue;
                
                // bfs 
                Queue<int[]> queue = new LinkedList<>();
                queue.offer(new int[] {i, j, -1});
                visited[i][j] = true;
                
                int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    for (int step = 0; step < size; step++) {
                        int[] cur = queue.poll();
                        char ch = grid[cur[0]][cur[1]];
                        // go forware the four direction, three direction
                        for (int k = 0; k < dirs.length; k++) {
                            // for the opposite direction
                            if (cur[2] == 0 && k == 1) continue;
                            if (cur[2] == 1 && k == 0) continue;
                            if (cur[2] == 2 && k == 3) continue;
                            if (cur[2] == 3 && k == 2) continue;
                            int cx = cur[0] + dirs[k][0];
                            int cy = cur[1] + dirs[k][1];
                            
                            if (cx < 0 || cx >= m) continue;
                            if (cy < 0 || cy >= n) continue;
                            
                            if (grid[cx][cy] != ch) continue;
                            
                            if (visited[cx][cy] == true) return true;
                            
                            queue.offer(new int[] {cx, cy, k});
                            visited[cx][cy] = true;
                        }
                    }
                }
            }
        }
        
        return false;
    }
}

// O(m*n*maxparthsize)
// O(m*n)
//      ^
//      |
// a -> a -> 
//      |>
         
//          a X b -> b
//          b   zX   b X
//          b   bX   a
