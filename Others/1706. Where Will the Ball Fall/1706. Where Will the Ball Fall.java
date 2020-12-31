class Solution {
    public int[] findBall(int[][] grid) {
        // dfs and emulate the process
        // first loop for every ball and second loop for every row moving position
        int m = grid.length, n = grid[0].length;
        int[] rets = new int[n];
        Arrays.fill(rets, -1);
        
        for (int j = 0; j < n; j++) {
            int x = 0, y = j; // begin coordinate
            while (x < m) {
                if (grid[x][y] == 1) {
                    if (y+1 == n) {
                        break;
                    } else if (grid[x][y+1] == -1) {
                        break;
                    } else {
                        // go right down;
                        x++;
                        y++;
                    }
                } else {
                    if (y-1 < 0) {
                        break;
                    } else if (grid[x][y-1] == 1) {
                        break;
                    } else {
                        // go right down;
                        x++;
                        y--;
                    }
                }
            }
            if (x == m) rets[j] = y;
        }
        
        return rets;
    }
}
