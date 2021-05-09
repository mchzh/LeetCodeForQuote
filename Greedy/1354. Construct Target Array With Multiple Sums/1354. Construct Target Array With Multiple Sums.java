class Solution {
    public boolean isPossible(int[] target) {
        int n = target.length;
        long sum = 0;
        PriorityQueue<Long> pq = new PriorityQueue<Long>((a, b) -> ((int)(b-a)));
        for (int t : target) {
            sum += t;
            pq.offer((long)t);
        }
        
        while (pq.peek() != 1) {
            long curm = pq.poll();
            long others = sum - curm;
            if (others == 0) return false;
            if (curm <= others) return false;
            long b = curm % others;
            //if (b <= 0) return false;
            sum = others+b;
            pq.offer(b);
        }
        return true;
    }
}
