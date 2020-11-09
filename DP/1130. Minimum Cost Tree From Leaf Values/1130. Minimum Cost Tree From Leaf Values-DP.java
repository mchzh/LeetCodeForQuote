class Solution {
    // dp and tricky
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int[] d : dp) Arrays.fill(d, Integer.MAX_VALUE);
        int[][] larger = new int[n][n];
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            dp[i][i] = arr[i];
            larger[i][i] = arr[i];
        }
        
        for (int len = 1; len <= n; len++) { // len can be started 2 cause k and k+1
            for (int i = 0; i+len-1 < n; i++) {
                int j = i+len-1;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + larger[i][k] * larger[k+1][j]);
                    larger[i][j] = Math.max(larger[i][k], larger[k+1][j]);
                }
            }
        }
        
        return dp[0][n-1] - sum;
    }
}

// [X X X X X X] [X X X X X X]
//      y1            y2
//             ret
// [i X X X X k] [k+1 X X X X j]

// state transition equation
// dp[i][j] = min { max[i][k] * max[k][j] + dp[i][k] + dp[k+1][j] }  k .st i... j-1
         
// for len = ....
//     for i = ....
//         j = i+len-1;
//         for k = i...j-1
//             dp[i][j] = min { max[i][k] * max[k+1][j] + dp[i][k] + dp[k+1][j] }
