class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length, m = multipliers.length;
        int[] cnums = new int[n+1];
        cnums[0] = 0;
        for (int i = 0; i < n; i++) cnums[i+1] = nums[i];
        int[][] dp = new int[m+1][m+1];
        for (int[] d : dp) Arrays.fill(d, Integer.MIN_VALUE/2);
        dp[0][0] = 0; // non -sel
        
        int rets = Integer.MIN_VALUE/2;
        for (int len = 1; len <= m; len++) {
            for (int i = 0; i <= len; i++) {
                int j = len-i;
                if (i >= 1) dp[i][j] = Math.max(dp[i][j], dp[i-1][j]+ cnums[i]*multipliers[i+j-1]);
                if (j >= 1) dp[i][j] = Math.max(dp[i][j], dp[i][j-1] + cnums[n-j+1]*multipliers[i+j-1]);
                
                if (len == m) rets = Math.max(rets, dp[i][j]); 
            }
        }
        
        return rets;
    }
}

// range dp general:
// dp[i][j]: the max/min solution between s[i...j] -> from center to boundary spread;

// this issue:
// dp[i][j]: the max/min solution with pick i elements from left and pich j elements from right

//   XXXXOOOOOXXXX
//      i     j
//     i+j = len -> care about left and right side, not middle part
//   XXX [X]OOOOOXXXX
//    i-1 i      j
//   XXXXOOOOOO[X] XXX
//      i       j j-1
    
// dp[i][j] = max (dp[i-1][j]+ nums[i]*multipliers[i+j], dp[i][j-1] + nums[j]*multipliers[i+j]);
