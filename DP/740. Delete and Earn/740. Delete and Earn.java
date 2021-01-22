class Solution {
    // pick or not pick
    // consider with house robber
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] count = new int[10001];
        int max = 0;
        for (int c : nums) {
            count[c]++;
            max = Math.max(max, c);
        }
        
        int p = 0, q = 0;
        for (int i = 1; i <= max; i++) {
            int p2 = p, q2 = q;
            p = q2+count[i]*i;
            q = Math.max(p2, q2);
        }
        return Math.max(p, q);
    }
}
// [2, 2, {3, 3, 3,} 4]
// p[i]: the maximum number of points by earning i
// q[i]: the maximum number of points by not earning i
// p[i] = q[i-1] + gain[i]
// q[i] = max(p[i-1], q[i-1]);

// =>
//     dp[i] = max(dp[i-2]+gain[i], dp[i-1])
