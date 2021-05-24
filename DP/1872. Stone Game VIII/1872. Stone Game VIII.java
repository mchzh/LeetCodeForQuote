class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int[] sum = new int[n+1];
        for (int i = 0; i < n; i++) {
            sum[i+1] += sum[i] + stones[i];
        }
        
        int[] dp = new int[n+1];
        dp[1] = 0;
        dp[2] = sum[n]-dp[1];
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i-1], sum[n-i+2]-dp[i-1]);
        }
        return dp[n];
    }
}

// dp[i]: with i stones left, the maximun score between starters

// [X X X X O]     dp[1] = 0
    
// [X X X X O] O   dp[2] = presum[n] - dp[1]

// [X X X X O] O O dp[3] = max()
//     1. pick 3 balls: presum[n] - dp[1]
//     2. pick 2 balls: presum[n-1] - dp[2]
    
// [X X X X O] O O O dp[4] = max() = (1 and 2) => dp[3]
//     1. pick 4 balls: presum[n] - dp[1]
//     2. pick 3 balls: presum[n-1] - dp[2]
//     3. pick 2 balls: presum[n-2] - dp[3]
    
//         dp[i] = max(dp[i-1], presum[n-i+2]-dp[i-1]);
