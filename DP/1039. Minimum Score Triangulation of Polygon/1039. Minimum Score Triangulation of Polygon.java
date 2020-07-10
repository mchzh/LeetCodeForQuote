class Solution {
    // https://leetcode.com/problems/minimum-score-triangulation-of-polygon/discuss/655162/Java-98.9-Time-and-1000-Space-DP-Memo.-Solution
    // similiar to 516
    // it belongs to interval dp
    public int minScoreTriangulation(int[] A) {
        int[][] dp = new int[A.length][A.length];
        helper(dp, 0, A.length-1, A);
        return dp[0][A.length-1];
    }
    private int helper(int[][] dp, int l, int h, int[] A) {
        // corner case
        if (l >= h) return 0;
        if (dp[l][h] != 0) return dp[l][h];
        
        if (h-l == 2) {
            int ans = A[l]*A[l+1]*A[h];
            dp[l][h] = ans;
            return ans;
        }
        
        dp[l][h] = Integer.MAX_VALUE;
        
        for (int k = l+1; k <= h-1; k++) {
            int curTri = A[l]*A[h]*A[k];
            if (k == l+1) {
                dp[l][h] = Math.min(dp[l][h], helper(dp, k, h, A) + curTri);
            } else if (k == h-1) {
                dp[l][h] = Math.min(dp[l][h], helper(dp, l, k, A) + curTri);;
            } else {
                dp[l][h] = Math.min(dp[l][h], helper(dp, l, k, A) + helper(dp, k, h, A) + curTri);;
            }
        }
        
        return dp[l][h];
    }
}
//    1  2
// 6         3
//    5  4

/*class Solution {
    private int minScoreTriangulationHelper(int[] A, int i, int j, int[][] dp) {
        if (j == i+1) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i+1; k < j; k++) {
            int left = minScoreTriangulationHelper(A, i, k, dp);
            int right = minScoreTriangulationHelper(A, k, j, dp);
            int curr = A[i] * A[k] * A[j];
            dp[i][j] = Math.min(curr + left + right, dp[i][j]);
        }
        return dp[i][j];
    }
    
    public int minScoreTriangulation(int[] A) {
        int len = A.length;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], -1);
        }
        return minScoreTriangulationHelper(A, 0, len-1, dp);
    }
}*/
