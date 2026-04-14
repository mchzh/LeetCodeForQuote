class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        int n = factory.length;
        int m = robot.size();
        // sort robt and factory
        Collections.sort(robot);
        Arrays.sort(factory, (a,b) -> (a[0] - b[0]));

        // compute the distance for every factory with robot range [s...t]
        long[][][] dist = new long[101][101][101];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) { // robot start pos
                long sum = 0;
                for (int k = j; k < m; k++) { // robot end pos
                    sum += Math.abs(factory[i][0] - robot.get(k));
                    dist[i][j][k] = sum;
                }
            }
        }

        long[][] dp = new long[n][m+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = Long.MAX_VALUE/2;
            }
        }
        // initialize
        // dp[0][j]
        // dp[i][0]
        dp[0][0] = 0;
        for (int j = 1; j <= m; j++) {
            if (j <= factory[0][1]) {
                dp[0][j] = dist[0][0][j-1];
            } else {
                dp[0][j] = Long.MAX_VALUE/2;
            }
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= m; j++) {
                //dp[i][j] = dp[i-1][j]; // k == 0
                for (int k = 0; k <= Math.min(j, factory[i][1]); k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-k] + dist[i][j-k][j-1]);
                }
            }
        }

        return dp[n-1][m];
    }
}

// X X X | X X X X| X X X 
//               j`      j
//               i-1     i
// dp[i][j]: the min total distance when stay at the first i factory and support j robots
// for (i....) {
//     for (j....) {
//         for (k = 0; k < factory[i] limit; k++) {
//             dp[i][j] = min(dp[i][j], dp[i-1][j-k] + dist(i, j-k+1, j)); // distance of the last k robots end with k
//         }
//     }
// }
