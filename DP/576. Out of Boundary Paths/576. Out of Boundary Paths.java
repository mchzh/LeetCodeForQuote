class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        long mod = (long)(1e9+7);
        int[][] dp = new int[m][n];
        int[][] temp = new int[m][n];

        for (int k = 0; k < maxMove; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    long a = (i-1 < 0) ? 1 : dp[i-1][j];
                    long b = (j-1 < 0) ? 1 : dp[i][j-1];
                    long c = (i+1 >= m) ? 1 : dp[i+1][j];
                    long d = (j+1 >= n) ? 1 : dp[i][j+1];

                    temp[i][j] = (int)((a+b+c+d)%mod);
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    
                    dp[i][j] = temp[i][j];
                }
            }
        }
        return dp[startRow][startColumn];
    }
}

//   # #
// # 2 2 #
// # 2 2 #
//   # #
