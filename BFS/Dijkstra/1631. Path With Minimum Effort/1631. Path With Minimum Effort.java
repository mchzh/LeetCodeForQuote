class Solution {
    // dp or bfs or dfs
    // directly dfs is TLE O(3m*n)
    int directions[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    class Cell {
        int x;
        int y;
        Integer diff;
        public Cell(int x, int y, Integer diff) {
            this.x = x;
            this.y = y;
            this.diff = diff;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        // Dijkstra's Algorithm
        int row = heights.length, col = heights[0].length;
        int[][] diffMatrix = new int[row][col];
        // initilized diffMatirx
        for (int[] d : diffMatrix) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        
        PriorityQueue<Cell> pq = new PriorityQueue<Cell>((a, b) -> (a.diff.compareTo(b.diff)));
        boolean[][] visited = new boolean[row][col];
        diffMatrix[0][0] = 0;
        pq.offer(new Cell(0, 0, diffMatrix[0][0]));
        //return backtrack(0, 0, heights, heights.length, heights[0].length, 0);
        
        while (!pq.isEmpty()) {
            Cell curr = pq.poll();
            visited[curr.x][curr.y] = true;
            if (curr.x == row-1 && curr.y == col-1) return curr.diff;
            
            for (int[] d : directions) {
                int cx = curr.x + d[0];
                int cy = curr.y + d[1];
                
                if (cx >= 0 && cx < row && cy >= 0 && cy < col && ! visited[cx][cy]) {
                    int currDiff = Math.abs(heights[cx][cy] - heights[curr.x][curr.y]);
                    int curMax = Math.max(currDiff, diffMatrix[curr.x][curr.y]);
                    if (diffMatrix[cx][cy] > curMax) {
                        //System.out.println(cx + " : " + cy + " : " + curMax);
                        diffMatrix[cx][cy] = curMax;
                        pq.offer(new Cell(cx, cy, curMax));
                    }
                }
            }
        }
        //System.out.println(diffMatrix[row-1][col-1]);
        return diffMatrix[row-1][col-1];
    }
}
