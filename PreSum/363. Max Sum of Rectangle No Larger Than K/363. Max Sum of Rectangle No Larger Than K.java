class Solution {
    // 2D presum
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] presum = new int[m+1][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                presum[i+1][j+1] = matrix[i][j] + presum[i][j+1] + presum[i+1][j] - presum[i][j];
            }
        }
        
        int com = Integer.MAX_VALUE;
        int rets = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l <= i; l++) {
                    for (int r = 0; r <= j; r++) {
                        int cur = presum[i+1][j+1] - presum[i+1][r] - presum[l][j+1] + presum[l][r];
                        if (cur <= k && Math.abs(cur-k) < com) {
                            com = Math.abs(cur-k);
                            rets = cur;
                        }
                    }
                }
            }
        }
        return rets;
    }
}

//O(M*M*N*N)
