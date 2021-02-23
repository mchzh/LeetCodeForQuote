class Solution {
    // depend on last round
    public int minSwap(int[] A, int[] B) {
        int n = A.length;
        int[][] dp = new int[n][2];
        for (int[] d : dp) {
            Arrays.fill(d, Integer.MAX_VALUE/2);
        }
        dp[0][0] = 0;
        dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            // i col non-swap
            if (A[i] > A[i-1] && B[i] > B[i-1]) {
                if (dp[i-1][0] != Integer.MAX_VALUE/2) dp[i][0] = Math.min(dp[i][0], dp[i-1][0]);  
            }
            if (A[i] > B[i-1] && B[i] > A[i-1]) {
                if (dp[i-1][1] != Integer.MAX_VALUE/2) dp[i][0] = Math.min(dp[i][0], dp[i-1][1]);
            }
            // i col swap
            if (B[i] > A[i-1] && A[i] > B[i-1]) {
                if (dp[i-1][0] != Integer.MAX_VALUE/2) dp[i][1] = Math.min(dp[i][1], dp[i-1][0]+1);  
            } 
            if (A[i] > A[i-1] && B[i] > B[i-1]) {
                if (dp[i-1][1] != Integer.MAX_VALUE/2) dp[i][1] = Math.min(dp[i][1], dp[i-1][1]+1);
            }
        }
        return Math.min(dp[n-1][0], dp[n-1][1]);
    }
}

// dp[i][0]: the minimum number of swaps to make both sequences strictly increasing without changing ai and bi end with index i for  A and B
// dp[i][1]:the minimum number of swaps to make both sequences strictly increasing with change ai and bi end with index i for  A and B

// 1. if (A[i] > A[i-1] && B[i] > B[i-1]) {
//         dp[i][0] = min(dp[i-1][0]);
// } else if (A[i] > B[i-1] && B[i] > A[i-1]) {
//         dp[i][0] = min(dp[i-1][1]);
// }
// 2. if (A[i] > B[i-1] && B[i] > A[i-1]) {
//         dp[i][1] = min(dp[i-1][1]+1);
// } else if (A[i] > A[i-1] && B[i] > B[i-1]) {
//         dp[i][0] = min(dp[i-1][0]+1);
// }
