class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        //TLE
        int N = nums.length;
        int[] dp = new int[N];
        int ret = nums[0];
        for (int i = 0; i < N; i++) {
            dp[i] = nums[i];
        }
        Deque<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < N; i++) {
            while (q.size() > 0 && q.getFirst() < i-k) q.pollFirst();
            if (q.size() > 0) dp[i] = Math.max(dp[i], nums[i] + dp[q.getFirst()]);
            
            while (q.size() > 0 && dp[i] >= dp[q.getLast()]) q.pollLast();
            q.offerLast(i);
            ret = Math.max(ret, dp[i]);
        }
        // for (int i = 1; i < N; i++) {
        //     int j = (i-k >=0) ? i-k : 0;
        //     for (; j < i; j++) {
        //         dp[i] = Math.max(dp[i], nums[i]+dp[j]);
        //     }
        //     ret = Math.max(ret, dp[i]);
        // }
        return ret;
    }
}
//dp[i] = nums[i] + max(0, dp[i-k], dp[i-k+1], ..., dp[i-1])
// deque to optimal
