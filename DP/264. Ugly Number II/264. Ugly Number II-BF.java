class Solution {
    public int nthUglyNumber(int n) {
        if (n == 1) return 1;
        long mod = (long)(1e9+7);
        PriorityQueue<Long> pq = new PriorityQueue();
        int count = 0;
        pq.offer((long)1);
        Set<Long> visited = new HashSet<>();
        visited.add((long)1);
        long rets = 0;
        while (count < n) {
            long cur = pq.poll();
            rets = cur;
            if (!visited.contains(cur*2)) {
                visited.add(cur*2);
                pq.offer(cur*2);
            }
            if (!visited.contains(cur*3)) {
                visited.add(cur*3);
                pq.offer(cur*3);
            }
            if (!visited.contains(cur*5)) {
                visited.add(cur*5);
                pq.offer(cur*5);
            }
            count++;
        }
        return (int)(rets);
    }
}
