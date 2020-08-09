class Solution {
    public int orangesRotting(int[][] grid) {
        // BFS
        int row = grid.length, col = grid[0].length;
        int freshCount = 0;
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }
        
        int[] dirs = {0, -1, 0, 1,0};
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                //next four
                for (int k = 0; k < dirs.length-1; k++) {
                    int cx = dirs[k]+cur[0];
                    int cy = dirs[k+1]+cur[1];
                    if (cx < 0 || cx >= row || cy < 0 || cy >= col) continue;
                    if (visited[cx][cy]) continue;
                    if (grid[cx][cy] == 0 || grid[cx][cy] == 2) continue;
                    grid[cx][cy] = 2;
                    visited[cx][cy] = true;
                    freshCount--;
                    if (freshCount == 0) return level;
                    queue.offer(new int[] {cx, cy});
                }
            }
            
        }
        
        return freshCount == 0 ? 0 : -1;
    }
}

/*class Solution {
    public int orangesRotting(int[][] grid) {
        int[] X = {0,0,1,-1};
        int[] Y = {1,-1,0,0};
        int freshCount=0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    freshCount++;
                } else if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        
        int days=0;
        while(!queue.isEmpty() && freshCount>0){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] curr = queue.poll();
                for(int k=0;k<4;k++){
                    int dx = curr[0]+X[k];
                    int dy = curr[1]+Y[k];
                    if(dx<0||dx>=grid.length||dy<0||dy>=grid[0].length||grid[dx][dy]!=1){
                        continue;
                    }
                    
                    grid[dx][dy] = 2;
                    queue.offer(new int[]{dx,dy});
                    freshCount--;
                }
                
            }
            days++;
        }
        return freshCount==0?days:-1;
    }
}*/
