class FreqStack {
    // pq, and take freq as a key {v, freq, pushsequence}
    int pushCount;
    PriorityQueue<int[]> pq;
    Map<Integer, Integer> map;
    public FreqStack() {
        pq = new PriorityQueue<>( (a, b) -> (a[1] == b[1] ? b[2]-a[2] : b[1]-a[1]) );
        map = new HashMap<>();
        pushCount = 0;
    }
    
    public void push(int x) {
        map.put(x, map.getOrDefault(x, 0) + 1);
        pq.offer(new int[] {x, map.get(x), pushCount++});
    }
    
    public int pop() {
        if (pq.isEmpty()) return -1;
        int[] rets = pq.poll();
        map.put(rets[0], map.getOrDefault(rets[0], 0) - 1);
        return rets[0];
    }
}
