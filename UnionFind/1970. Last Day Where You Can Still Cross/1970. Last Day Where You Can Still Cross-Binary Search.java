class Solution {
    // BFS + binary search
    // BFS for graph tranverse
    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 1, right = cells.length;

        while (left < right) {
            int mid = right - (right - left) / 2;
            if (isConnect(row, col, mid, cells)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    private boolean isConnect(int row, int col, int pos, int[][] cells) {
        int[][] matrix = new int[row][col];
        for (int i = 0; i < pos; i++) {
            int x = cells[i][0], y = cells[i][1];
            matrix[x-1][y-1] = 1;
        }
        
        // BFS: first row element with zero to push into queue
        Queue<int[]> q = new LinkedList<>();
        for (int j = 0; j < col; j++) {
            if (matrix[0][j] == 0) {
                q.offer(new int[] {0, j});
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int x = cur[0], y = cur[1];
                if (x == row-1) return true;

                int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
                for (int k = 0; k < 4; k++) {
                    int cx = x + dirs[k][0];
                    int cy = y + dirs[k][1];
                    if (cx < 0 || cx >= row || cy < 0 || cy >= col) continue;
                    if (matrix[cx][cy] != 0) continue;
                    q.offer(new int[] {cx, cy});
                    matrix[cx][cy] = 2;
                }
            }
        }
        return false;
    }
}
