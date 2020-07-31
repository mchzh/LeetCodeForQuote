class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
//         PriorityQueue<Integer> pq = new PriorityQueue<>( (a, b) -> (b-a) );
//         int[] res = new int[nums.length-k+1];
//         for (int i = 0; i < nums.length; i++) {
//             pq.offer(nums[i]);
//             if (pq.size() > k) pq.remove(nums[i-k]);
            
//             if (i >= k-1) {
//                 res[i-k+1] = pq.peek();
//             }
//         }
//         return res;
        Deque<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length-k+1];
        for (int i = 0; i < nums.length; i++) {
            while (queue.size() > 0 && nums[i] > nums[queue.getLast()]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            // outdated
            while (queue.size() > 0 && queue.getFirst()<= i-k) queue.pollFirst();
            if (i >= k-1) {
                res[i-k+1] = nums[queue.getFirst()];
            }
        }
        return res;
    }
}
// heap will TLE
// deque
// monotone queue

// [3, -1, -3] 5
// [3, -1, 5]
// [3, 5]

// 1. maintain a mono-decreading queue;
// 2. check if the head of queue is out dated;
// 3. the maximun of the slide window is the head;

/*class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        int l = 0;
        int[] res = new int[nums.length-k+1];
        int saveIdx = 0;
        for(int r=0; r<nums.length; r++) {
            while(!q.isEmpty() && nums[q.peekLast()] < nums[r]) {
                q.pollLast();
            }
            q.offerLast(r);
            if (r-l+1 == k) {
                res[saveIdx++] = nums[q.peekFirst()];
                if (q.peekFirst() == l) {
                    q.removeFirst();
                }
                l ++;
            }
        }
        return res;
    }
}*/
