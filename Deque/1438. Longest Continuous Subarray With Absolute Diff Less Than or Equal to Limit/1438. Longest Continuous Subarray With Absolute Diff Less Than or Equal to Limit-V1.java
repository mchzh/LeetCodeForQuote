class Solution {
    // priority queue
    // dqueue
    // two dqueue to keep current max and min
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        Deque<Integer> maxdq = new LinkedList<>();
        Deque<Integer> mindq = new LinkedList<>();
        int rets = 0;
        int left = 0;
        for (int i = 0; i < n; i++) {
            int a = nums[i];
            // max into que
            while (!maxdq.isEmpty() && (nums[maxdq.peekLast()] < a)) {
                maxdq.removeLast();
            }
            while (!mindq.isEmpty() && (nums[mindq.peekLast()] > a)) {
                mindq.removeLast();
            }
            maxdq.offerLast(i);
            mindq.offerLast(i);
            if (nums[maxdq.peekFirst()] - nums[mindq.peekFirst()] <= limit) {
                rets = Math.max(rets, i-left+1);
            }
            // while current diff > limit
            int curmax = nums[maxdq.peekFirst()];
            int curmin = nums[mindq.peekFirst()];
            while (left < i && (curmax -curmin > limit)) {
                if (left == maxdq.peekFirst()) {
                    maxdq.removeFirst();
                }
                if (left == mindq.peekFirst()) {
                    mindq.removeFirst();
                }
                left++;
                curmax = nums[maxdq.peekFirst()];
                curmin = nums[mindq.peekFirst()];
            }
        }
        return rets;
    }
}
