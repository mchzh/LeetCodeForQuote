class Solution {
    // dp X or bfs or dfs (X)
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
                    int curMax = Math.max(currDiff, curr.diff);
                    if (diffMatrix[cx][cy] > curMax) {
                        diffMatrix[cx][cy] = curMax;
                        pq.offer(new Cell(cx, cy, diffMatrix[cx][cy]));
                    }
                }
            }
        }
        return diffMatrix[row-1][col-1];
    }

    int maxSoFar = Integer.MAX_VALUE;

    int backtrack(int x, int y, int[][] heights, int row, int col, int maxDifference) {
        if (x == row - 1 && y == col - 1) {
            maxSoFar = Math.min(maxSoFar, maxDifference);
            return maxDifference;
        }
        int currentHeight = heights[x][y];
        heights[x][y] = 0;
        int minEffort = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            int adjacentX = x + directions[i][0];
            int adjacentY = y + directions[i][1];
            if (isValidCell(adjacentX, adjacentY, row, col) && heights[adjacentX][adjacentY] != 0) {
                int currentDifference = Math.abs(heights[adjacentX][adjacentY] - currentHeight);
                int maxCurrentDifference = Math.max(maxDifference, currentDifference);
                if (maxCurrentDifference < maxSoFar) {
                    int result = backtrack(adjacentX, adjacentY, heights, row, col, maxCurrentDifference);
                    minEffort = Math.min(minEffort, result);
                }
            }
        }
        heights[x][y] = currentHeight;
        return minEffort;
    }

    boolean isValidCell(int x, int y, int row, int col) {
        return x >= 0 && x <= row - 1 && y >= 0 && y <= col - 1;
    }
}
