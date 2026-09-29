class Solution {
    // dp
    // optimizer condition: (M+n-1)-(i+j+1) >= (x+k);
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        Set<Integer>[][] dp = new Set[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new HashSet<>();
            }
        }
        if (grid[0][0] == '(') {
            dp[0][0].add(1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i][j];
                int k = (c=='(') ? 1 : -1;
                if (i > 0) {
                    for (int x : dp[i-1][j]) {
                        if (x+k >= 0 && ((m+n-1)-(i+j+1) >= (x+k))) {
                            dp[i][j].add(x+k);
                        }
                    }
                }
                
                if (j > 0) {
                    for (int x : dp[i][j-1]) {
                        if (x+k >= 0 && ((m+n-1)-(i+j+1) >= (x+k))) {
                            dp[i][j].add(x+k);
                        }
                    }
                }
            }
        }
        return dp[m-1][n-1].contains(0);
    }
}
// dp[i][j][k]: i and j pos with k number left par
