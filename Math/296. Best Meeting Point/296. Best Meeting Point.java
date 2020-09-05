class Solution {
    public int minTotalDistance(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0;  j < col; j++) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        
        Collections.sort(rows);
        Collections.sort(cols);
        int m = rows.get(rows.size()/2), n = cols.get(cols.size()/2);
        
        int ret = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0;  j < col; j++) {
                if (grid[i][j] == 1) {
                    ret+= Math.abs(i-m) + Math.abs(j-n);
                }
            }
        }
        return ret;
    }
}

// median point

// P: |x1-x| + |y1-y| + |x2-x| + |y2-y| + .... + |xn-x| + |yn -y|
// x: argmin (|x1-x| + |x2-x| + .... + |xn-x|);
// y: argmin (|y1-y| + |y2-y| + .... + |yn -y|);

// x: argmin (|x1-x| + |x2-x| + .... + |xn-x|);
//   = median of (xi)
      
// *  *    *   *  *
