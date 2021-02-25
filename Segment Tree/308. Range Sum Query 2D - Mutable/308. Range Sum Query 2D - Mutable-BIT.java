class NumMatrix {
    // consider segment tree
    int[][] tree;
    int[][] nums;
    int m;
    int n;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        m = matrix.length;
        n = matrix[0].length;
        this.tree = new int[m+1][n+1];
        this.nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }
    
    public void update(int row, int col, int val) {
        if (m == 0 || n == 0) return;
        int delta = val - nums[row][col];
        nums[row][col] = val;
        for (int i = row + 1; i <= m; i += lsb(i)) {
            for (int j = col + 1; j <= n; j += lsb(j)) {
                tree[i][j] += delta;
            }
        }
    }
    public int lsb(int n) {
        return n&(-n);
    }
    
    public int getSum(int x, int y) {
        int ret = 0;
        for (int i = x; i > 0; i -= lsb(i)) {
            for (int j = y; j > 0; j -= lsb(j)) {
                ret += tree[i][j];
            }
        }
        return ret;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return getSum(row2+1, col2+1) + getSum(row1, col1) - getSum(row2+1, col1) - getSum(row1, col2+1);
    }
}
