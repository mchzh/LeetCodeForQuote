class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Deque<Integer> dq = new LinkedList<>(); // save indx
        for (int i = 1; i <= n; i++) dp[i] = Integer.MIN_VALUE;
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            
            dp[i] = Math.max(dp[i], (dq.isEmpty() ? 0 : dp[dq.peekFirst()]) + nums[i-1]);
            // add new num into dq with k window
            int curadd = dp[i];
            if (!dq.isEmpty() && i-dq.peekFirst() == k) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && dp[dq.peekLast()] < curadd) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        return dp[n];
    }
}

// dp[i]: the maximum score you can get when you reach the ith pos

// max(dp[i-k], dp[i-k+1],...., dp[i-1]) + nums[i]-> dp[i]
// deque to hold the current k window max value
