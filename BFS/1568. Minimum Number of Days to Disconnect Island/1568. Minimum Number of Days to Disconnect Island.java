class Solution {
    int m, n;
    public int minDays(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int num = isLand(grid);
        if (num > 1 || num == 0) return 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                grid[i][j] = 0;
                num = isLand(grid);
                if (num > 1 || num == 0) return 1;
                grid[i][j] = 1;
            }
        }
        
        return 2;
    }
    private int isLand(int[][] grid) {
        
        // bfs to get island num
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        //System.out.println("bfs enter -> " + count);
        //for () {}
        
        for (int i = 0; i < m; i++) {
            //System.out.println("first loop -> " + i);
            for (int j = 0; j < n; j++) {
                //System.out.println("bfs start -> " + grid[i][j]);
                if (grid[i][j] == 0) continue;
                if (visited[i][j] == true) continue;
                
                //System.out.println("start island -> " + grid[i][j] + " : x -> " + i + " : y -> " + j);
                // bfs
                Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
                queue.offer(new Pair(i, j));
                visited[i][j] = true;
                while (!queue.isEmpty()) {
                    Pair cur = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int a = (int)cur.getKey() + dirs[k][0];
                        int b = (int)cur.getValue() + dirs[k][1];
                        
                        if (a < 0 || a >= m || b < 0 || b >= n) continue;
                        if (visited[a][b] == true) continue;
                        if (grid[a][b] == 0) continue;
                        
                        queue.offer(new Pair(a, b));
                        visited[a][b] = true;
                    }
                }
                count += 1;
                if (count > 1) return 2;
            }
        }
        
        return count;
        
    }
}

// 0 1 2

//     x         0
//   x x x  -> 0 x 0
//     x         0
