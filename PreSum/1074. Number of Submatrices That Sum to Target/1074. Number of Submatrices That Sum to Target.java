class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int[][] presum = new int[m+1][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                presum[i+1][j+1] = matrix[i][j] + presum[i][j+1] + presum[i+1][j] - presum[i][j];
            }
        }
        
        int rets = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l <= i; l++) {
                    for (int r = 0; r <= j; r++) {
                        int cur = presum[i+1][j+1] - presum[i+1][r] - presum[l][j+1] + presum[l][r];
                        if (cur == target) {
                            rets++;
                        }
                    }
                }
            }
        }
        return rets;
    }
}
