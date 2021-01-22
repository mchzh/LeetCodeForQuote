class Solution {
    // LIS with more complicated coverage
    public int maxHeight(int[][] cuboids) {
        int n = cuboids.length;
        for (int i = 0; i < n; i++) {
            Arrays.sort(cuboids[i]);
        }
        Arrays.sort(cuboids, (a, b) -> ( a[0] == b[0] ? (a[1] == b[1] ? a[2]-b[2] : a[1]-b[1]) : a[0]-b[0]));
        
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = cuboids[i][2];
            for (int j = 0; j < i; j++) {
                if (cuboids[j][0] <= cuboids[i][0] && cuboids[j][1] <= cuboids[i][1]
                   && cuboids[j][2] <= cuboids[i][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
                }
            }
        }
        int rets = 0;
        for (int i = 0; i < n; i++) {
            rets = Math.max(rets, dp[i]);
        }
        return rets;
    }
}

// 3!= 6
// every cuboids[i] has 6 rotate pattern
// only {min(a,b,c), mid(a,b,c), max(a,b,c)} is the most optimal
