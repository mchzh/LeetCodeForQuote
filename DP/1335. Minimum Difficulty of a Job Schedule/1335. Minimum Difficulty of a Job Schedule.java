class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int N = jobDifficulty.length;
        int[] subarray = new int[N+1];
        int[][] dp = new int[N+1][d+1];
        for (int i = 0; i < N; i++) {
            subarray[i+1] = jobDifficulty[i];
            Arrays.fill(dp[i], Integer.MAX_VALUE/2);
        }
        Arrays.fill(dp[N], Integer.MAX_VALUE/2);
        dp[0][0] = 0;
        
        for (int i = 1; i <= N; i++) {
            for (int k = 1; k <= Math.min(i, d); k++) {
                int curMax = subarray[i];
                for (int j = i; j >= k; j--) {
                    //if (j-1 < k-1) continue;
                    curMax = Math.max(curMax, subarray[j]);
                    dp[i][k] = Math.min( dp[i][k], dp[j-1][k-1] + curMax );
                }
            }
        }
        if (dp[N][d] >= Integer.MAX_VALUE/2) return -1;
        else return dp[N][d];
    }
}

// split k part subarray
// Given an array, minimize "the sum of each maximum of subarray"
// X X X X X X X

// {X X X X X} [j Y Y Y i]
//   k-1            1
      
// dp[i][k] : Given an array S[0 : i], minimize "the sum of each maximum of k subarray"
// dp[i][k] = dp[j-1][k-1] + max(j : i);
