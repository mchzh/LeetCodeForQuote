class Solution {
    public int maxValue(int[][] events, int k) {
        int n = events.length;
        Arrays.sort(events, (a, b) -> (a[1] - b[1]));
        int[] endtime = new int[n+1];
        endtime[0] = 0;
        for (int i = 0; i < n; i++) endtime[i+1] = events[i][1];
        // add virtual node into events
        int[][] eventsb = new int[n+1][3];
        eventsb[0] = new int[] {0, 0, 0};
        for (int i = 0; i < n; i++) eventsb[i+1] = events[i];
        
        int[][] dp = new int[n+1][k+1];
        for (int[] d : dp) {
            Arrays.fill(d, Integer.MIN_VALUE/2);
            d[0] = 0;
        }
        
        int rets = 0;
        for (int i = 1; i <= n; i++) {
            int j = getAvailable(eventsb[i][0], endtime, i-1);
            for (int t = 1; t <= k; t++) {
                dp[i][t] = Math.max(dp[i-1][t], dp[j][t-1] + eventsb[i][2]);
            }
        }
        
        for (int t = 1; t <= k; t++) rets = Math.max(rets, dp[n][t]);
        return rets;
    }
    private int getAvailable(int target, int[] end, int right) {
        int left = 0;
        while (left < right) {
            int mid = right - (right-left)/2;
            if (end[mid] >= target) right = mid-1;
            else left = mid;
        }
        return left;
    }
}

// the maximum number of non-overlapping intervals => sorted by ending
// the minimum number of intervals that cover the whole range => sorted by start
// -------------      (select the earliest close end)
//   --------------
//         --------------
//                -----------
//                   ----------
// 1235: the maximum weights of non-overlapping intervals
// ----------
//       ------------
//         -------------
//           -------------
// dp[i][t] : the maximum weights you can gain by picking t intervals from the first i intervals

// 1. non-select:
//    dp[i][t] = dp[i-1][t];
// 2. select :
//    dp[i][t] = dp[j][t-1] + val[i];
