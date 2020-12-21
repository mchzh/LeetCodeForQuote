class Solution {
    // dp + slide window maximum
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        Deque<int[]> dq = new LinkedList<>();
        dq.addFirst(new int[] {nums[0], 0});
        
        for (int i = 1; i < n; i++) {
            // obselete head element
            if (!dq.isEmpty() && i-dq.peekFirst()[1] > k) {
                dq.removeFirst();
            }
            
            int curStep = dq.peekFirst()[0] + nums[i];
            // keep monotonic decreasing stack
            while (!dq.isEmpty() && dq.peekLast()[0] < curStep) {
                dq.removeLast();
            }
            
            dq.addLast(new int[] {curStep, i});
        }
        return dq.peekLast()[0];
    }
}

// max(dp[i-k], dp[i-k+1], ... dp[i-1]) + nums[i] => dp[i]
// max(dp[i-k+1], dp[i-k+2], ... dp[i-1], dp[i]) + nums[i+1] => dp[i+1]
// [8, 7,6, 5]  7 X X X
// [8, 7,7] X X X
