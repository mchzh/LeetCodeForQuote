class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // dij: pq save with point+cost+steps
        // create graph
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] f : flights) {
            int from = f[0];
            int to = f[1];
            int cost = f[2];
            graph.computeIfAbsent(from, t -> new ArrayList<>()).add(new int[] {to, cost});
        }
        
        int[][] visited = new int[k+2][n];
        for (int[] v : visited) Arrays.fill(v, Integer.MAX_VALUE/2);
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a, b) -> (a[1] - b[1]) );
        pq.offer(new int[] {src, 0, 0});
        visited[0][src] = 0;
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int p = cur[0];
            int cost = cur[1];
            int steps = cur[2];
            if (p == dst) return cost;
            if (steps == k+1) continue;
            
            if (!graph.containsKey(p)) continue;
            for (int[] next : graph.get(p)) {
                if (cost + next[1] < visited[steps+1][next[0]]) {
                    visited[steps+1][next[0]] = cost + next[1];
                    pq.offer(new int[] {next[0], cost + next[1], steps+1});
                }
                
            }
        }
        
        return -1;
    }
}


// midway: 3 stops 10 costs
// midway: 3 stops 20 costs
// previous exist a more smaller cost then ignore the same stop with same point with larger cost
