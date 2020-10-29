class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        // add start and end into this array
        int[] newCuts = new int[cuts.length+2];
        newCuts[0] = 0;
        newCuts[cuts.length+1] = n;
        for (int i = 0; i < cuts.length; i++) {
            newCuts[i+1] = cuts[i];
        }
        
        int m = newCuts.length;
        int[][] dp = new int[m][m];
        for (int[] d : dp) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        for (int i = 0; i < m; i++) {
            //dp[i][i] = 0;
            if (i != m-1) dp[i][i+1] = 0;
        }
        
        for (int len = 3; len <= m; len++) {
            for (int i = 0; i+len-1 < m; i++) {
                int j = i+len-1;
                for (int k = i+1; k < j; k++) {
                    //System.out.println(i + " : " + j + " : " + k);
                    dp[i][j] = Math.min(dp[i][j], (newCuts[j]-newCuts[i]) + dp[i][k] + dp[k][j]);
                }
            }
        }
        return dp[0][m-1];
    }
}

// dp[i][j] : the minimum total cost of the cuts for sticks between cuts[i] and cuts[j] (inclusive)
// dp[i][j] = min(dp[i][k] + dp[k][j] + cost-> (cuts[j]-cuts[i]) ) k possible .st i<k<j

// for (int len = 0; len <= m; len++) {
//     for (int i = 0; i <= n-len; i++) {
//         int j = i+len-1;
//         for (int k > i; k < j; k++) {
//             if ( k == ) {
//                 dp[i][j] = Math.min( (j-i) + dp[i][k] + dp[k][j]);
//             }
//         }
//     }
// }
// return dp[0][n];
