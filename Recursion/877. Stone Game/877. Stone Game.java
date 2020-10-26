class Solution {
    // dp[i][j] means the biggest number of stones you can get more than opponent picking piles in piles[i] ~ piles[j].
    // from up to bottom, dp is from bottom to up
    int[][] dp = new int[501][501];
    int[] presum;
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        presum = new int[n+1];
        for (int i = 0; i < n; i++) {
            presum[i+1] = presum[i] + piles[i];
        }
        
        int gain = solve(piles, 1, n);
        return gain > presum[n] - gain;
    }
    private int solve(int[] piles, int a, int b) {
        if (a == b) return piles[a-1];
        if (dp[a][b] != 0) return dp[a][b];
        
        //dp[a][b] = Math.max(presum[b]-presum[a]+piles[a-1], presum[b-1]-presum[a-1]+piles[b-1]);
        dp[a][b] = Math.max(presum[b]-presum[a-1]-solve(piles, a+1, b), presum[b]-presum[a-1]-solve(piles, a, b-1));
        return dp[a][b];
    }
}


// [X] X X X X X [X]
// solve(1, n)
//     1. 1st pos => piles[1] + sum[2..n] - solve(2, n) => sum[1...n] - solve(2, n)
//     2. nth pos => piles[n] + sum[1..n-1] - solve(1, n-1) => sum[1...n] - solve(1, n-1)
