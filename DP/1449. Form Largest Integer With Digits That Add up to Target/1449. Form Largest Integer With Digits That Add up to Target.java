class Solution {
    public String largestNumber(int[] cost, int target) {
        int n = cost.length;
        String[] dp = new String[target+1];
        
        dp[0] = "";
        for (int c = 1; c <= target; c++) {
            dp[c] = "#";
            for (int i = 1; i <= n; i++) {
                if (c < cost[i-1] || dp[c-cost[i-1]].equals("#")) continue;
                String cur = dp[c-cost[i-1]] + (char)(i+'0');
                
                if (cur.length() > dp[c].length()) {
                    dp[c] = cur;
                } else if (cur.length() == dp[c].length()) {
                    if (dp[c].compareTo(cur) < 0) {
                        dp[c] = cur;
                    }
                }   
            }
        }

        if (dp[target].equals("#")) return "0";
        else return dp[target];
    }
}

// dp[i][j]: the maximum integer you can paint with the ith object and j capacity

// unlimited knapsnack
// dp[i][j] = max(dp[i-1][j], dp[i][j-cost[i]]+w[i])
// String[][] dp = new String[n+1][target+1];
//     for (int c = 1; c <= target; c++) {
//         for (int i = 1; i <= n; i++) {
//             dp[i][c] = dp[i-1][c];
//             if (c-cost[i-1] >= 0) {
//                 String cur = dp[i][c-cost[i-1]] + 'i';
//                 if (dp[i][c].compareTo(cur) < 0) {
//                     dp[i][c] = cur;
//                 }
//             }
            
//         }
//     }
// return dp[n][target];
