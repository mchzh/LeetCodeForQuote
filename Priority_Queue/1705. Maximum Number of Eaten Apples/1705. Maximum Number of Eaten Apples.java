class Solution {
    // pq
    public int eatenApples(int[] apples, int[] days) {
        int n = apples.length;
        int rets = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a, b) -> (a[0]-b[0]) );
        
        int day = 0;
        while (day < n || !pq.isEmpty()) {
            // eat the earliest rot
            while (!pq.isEmpty() && pq.peek()[0] <= day) { // rotten apple
                pq.poll();
            }
            
            if (day < n && apples[day] != 0) {
                pq.offer(new int[] {day+days[day], apples[day]});
            }
            
            if (!pq.isEmpty()) {
                int[] cur = pq.poll();
                rets++;
                if (cur[1] >= 2) {
                    pq.offer(new int[] {cur[0], cur[1]-1});
                }
            }
            day++;
        }
        
        return rets;
    }
}

// NlgN
// heap
// n = 4e4
