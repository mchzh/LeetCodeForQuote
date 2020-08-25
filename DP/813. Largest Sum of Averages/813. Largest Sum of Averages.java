class Solution {
    // dp: the largest score at i position with j split
    public double largestSumOfAverages(int[] A, int K) {
        double[][] dp = new double[A.length][K+1];
        // dp[i][1] represent one cut which get all current elements
        int cur = 0;
        for (int i = 0; i < A.length; i++) {
            cur += A[i];
            dp[i][1] = cur*1.0/(i+1);
        }
        
        for (int k = 2; k <= K; k++) {
            for (int i = k-1; i < A.length; i++) {
                // get avg on dp step
                // for avg, it is better from end to begin loop, update dp[i][k]
                int sum = 0;
                for (int j = i; j >= k-1; j--) {
                    sum += A[j];
                    dp[i][k] = Math.max(dp[i][k], dp[j-1][k-1] + sum*1.0/(i-j+1));
                }
            }
        }
        return dp[A.length-1][K];
    }
}

// {X X X X X} [j X i]
// X X X X X X X i
//  | |   |   |
    
// on i positon, cut the jth split
// dp[i][j]: for ( 0 ... i-1) {
//             dp[i][j] = dp[i-1][j-1] + A[i], dp[i-2][j-1] + (A[i]+A[i-1])/2 + .... +
//                 dp[0][j-1]+(A[i] + .. A[0])/i;
//         }
// dp[i][K]:
// = max{dp[j][K-1]+avg{j+1, i}}
