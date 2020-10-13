class Solution {
    public int minDistance(int[] houses, int K) {
        int N = houses.length;
        Arrays.sort(houses);
        int[] vhouses = new int[N+1];
        vhouses[0] = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            vhouses[i+1] = houses[i];
        }
        // calculate the manhaton distance
        // three loop
        int[][] range = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = i; j <= N; j++) {
                range[i][j] = 0;
                // get median point
                for (int k = i; k <= j; k++) {
                    range[i][j] += Math.abs(vhouses[k] - vhouses[(i+j)/2]);
                }
            }
        }
        
        int[][] dp = new int[N+1][K+1];
        //dp[i][1]
        for (int i = 1; i <= N; i++) {
            dp[i][1] = range[1][i];
        }
        
        for (int i = 1; i <= N; i++) {
            for (int k = 2; k <= K; k++) {
                dp[i][k] = Integer.MAX_VALUE/2;
                for (int j = 0; j+1 <= i; j++) {
                    dp[i][k] = Math.min(dp[i][k], dp[j][k-1] + range[j+1][i]);
                }
            }
        }
        return dp[N][K];
    }
}

// group i and k

// dp[i][k] : the minimum total distance between each house and its nearest mailbox for house[0...i] covered k maiboxes

// [XXXXXXXXX] XXX
//   k-1        * i
//          j  j+1
    
// dp[i][k] = min(dp[j][k-1] + range[j+1][i]);

// range is to put a mailbox and keep the minum distance for house[j+1...i], that is manhanton distance and meian point is our target

// *  *  *  * *
//     ^ ^ ^
