class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int[][] dp = new int[n+1][minProfit+1];
        int[][] dp_new = new int[n+1][minProfit+1];
        dp[0][0] = 1;
        int mod = (int)(1e9+7);
        
        for (int k = 0; k < group.length; k++) {
            int x = group[k];
            int y = profit[k];
            
            for (int i = 0; i <= n; i++) {
                dp_new[i] = Arrays.copyOf(dp[i], dp[i].length);
            }
            //int[][] dp_new = Arrays.copyOf(dp, dp.length);
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= minProfit; j++) {
                    if (i+x <= n) {
                        int cur = Math.min(j+y, minProfit);
                        dp_new[i+x][cur] += dp[i][j];
                        dp_new[i+x][cur] %= mod;
                    } 
                }  
            }
            for (int i = 0; i <= n; i++) {
                dp[i] = Arrays.copyOf(dp_new[i], dp_new[i].length);
            }
        }
        
        int rets = 0;
        for (int i = 0; i <= n; i++) {
            rets = (rets+dp[i][minProfit])%mod;
        }
        return rets;
    }
}

// dp[person][profit] : the number of schemes that can be chosen with person and profit

// dp[person+g[i]][profit+p[i]] += dp[person][profit]

//   {4, 4}
// ->{5, 5}
