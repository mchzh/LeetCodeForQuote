class Solution {
    // with 632
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>( (a, b) -> (b-a) );
        
        int curmin = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n%2 == 1) {
                curmin = Math.min(curmin, n*2);
                pq.offer(n*2);
            } else {
                curmin = Math.min(curmin, n);
                pq.offer(n);
            }
        }
        
        int rets = Integer.MAX_VALUE;
        while (true) {
            rets = Math.min(rets, pq.peek()-curmin);
            
            int cur = pq.poll();
            if (cur%2 ==0) {
                curmin = Math.min(curmin, cur/2);
                pq.offer(cur/2);
            } else {
                break;
            }
        }
        return rets;
    }
}

// candidate array:
// [1, 2]
// [2, 1]
// [3, 6]
// [4, 2, 1]
