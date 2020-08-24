class Solution {
    public int surfaceArea(int[][] grid) {
        // four direction
        int N = grid.length;
        int[] dirs = {0, -1, 0, 1, 0};
        
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0) continue;
                res += 2;
                for (int k = 0; k < 4; k++) {
                    int nextX = i+dirs[k];
                    int nextY = j+dirs[k+1];
                    int nv = 0;
                    if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                        nv = grid[nextX][nextY];
                    }
                    
                    res += Math.max(grid[i][j]-nv, 0);
                }
            }
        }
        return res;
    }
}

/*class Solution {

  public int surfaceArea(int[][] grid) {
    int num = 0;
    int adjoin = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (0 < grid[i][j]) {
          num += grid[i][j];
          if (0 < j) {
            if (grid[i][j - 1] < grid[i][j]) {
              adjoin += grid[i][j - 1];
            } else {
              adjoin += grid[i][j];
            }
          }
          adjoin += grid[i][j] - 1;
          if (0 < i) {
            if (grid[i - 1][j] < grid[i][j]) {
              adjoin += grid[i - 1][j];
            } else {
              adjoin += grid[i][j];

            }

          }
        }
      }
    }
    return 6 * num - 2 * adjoin;
  }
}*/
