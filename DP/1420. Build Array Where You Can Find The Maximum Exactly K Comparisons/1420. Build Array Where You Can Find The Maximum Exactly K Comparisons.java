class Solution {
    public int numOfArrays(int n, int m, int k) {
        int c = k;
        long[][][] dp = new long[n][m+1][c+1];
        int mod = (int)(1e9+7);
        //dp[0][?][1] => cost at least one
        for (int i = 1; i <= m; i++) {
            dp[0][i][1] = 1;
        }
        
        for (int i = 1; i < n; i++) 
            for (int j = 1; j <= m; j++) 
                for (int s = 1; s <= c; s++) {
                    for (int t =1; t <= j-1; t++)
                        dp[i][j][s] = (dp[i][j][s] + dp[i-1][t][s-1])%mod;
                    
                    dp[i][j][s] = (dp[i][j][s] +dp[i-1][j][s] * j)%mod;
                }
        
        long rets = 0;
        //dp[n-1][?][c]
        for (int i = 1; i <= m; i++) {
            rets = (rets + dp[n-1][i][c])%mod;
        }
        return (int)rets;
    }
}

// dp[i][j][k]: the number of ways at arr[1...i] with the maxium value j(max(arr[1...i]) = j) and search cost is k

// X X X X X X i
//        j k
// if arr[i] is the largest among arr[1...i] => arr[i] = j;
// dp[i][j][k] += sum(dp[i-1][1...j-1][k-1]);
// if arr[i] is not the largest among arr[1...i] => arr[i] <= j;
// dp[i][j][k] += dp[i-1][j][k] * j;
