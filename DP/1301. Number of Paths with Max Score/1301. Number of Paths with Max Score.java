class Solution {
    // dp from bottom right to left-top
    public int[] pathsWithMaxScore(List<String> board) {
        long mod = (long)(1e9+7);
        int m = board.size(), n = board.get(0).length();
        long[][] dp = new long[m][n]; //  the maximum sum of numeric characters you can collect at i and j:
        // dp[i][j]= max(dp[i+1][j],dp[i][j+1], dp[i+1][j+1]) + board[i][j]
        long[][] path = new long[m][n]; // the number of such paths that you can take to get that maximum sum at i and j:
        // path[i][j]= max(path[i+1][j],path[i][j+1], path[i+1][j+1])
        for (long[] d : dp) {
            Arrays.fill(d, -1L);
        }

        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (board.get(i).charAt(j) == 'X') {
                    continue;
                }
                if (board.get(i).charAt(j) == 'S') {
                    dp[i][j] = 0L;
                    path[i][j] = 1L;

                    continue;
                }
                long down = -1, right = -1, diag = -1;
                if (i+1 < m) {
                    down = dp[i+1][j];
                }
                if (j+1 < n) {
                    right = dp[i][j+1];
                }
                if (i+1 < m && j+1 < n) {
                    diag = dp[i+1][j+1];
                }
                dp[i][j] = Math.max(diag, Math.max(down, right));
                //System.out.println(i + " : " + j + " : " + dp[i][j]);

                if (dp[i][j] == -1L) {
                    continue;
                }
                // max sum same + path
                if (i+1 < m && down != -1 && down == dp[i][j]) {
                    path[i][j] = (path[i][j]+path[i+1][j])%mod;
                }
                if (j+1 < n && right != -1 && right == dp[i][j]) {
                    path[i][j] = (path[i][j]+path[i][j+1])%mod;
                }
                if (i+1 < m && j+1 < n && diag != -1 && diag == dp[i][j]) {
                    path[i][j] = (path[i][j]+path[i+1][j+1])%mod;
                }

                dp[i][j] += board.get(i).charAt(j)=='E' ? 0L : (long)(board.get(i).charAt(j)-'0');
                dp[i][j] %= mod;
            }
        }

        return new int[]{(int)(dp[0][0]==-1 ? 0 : dp[0][0]), (int)path[0][0]};
    }
}
