class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // create adjacent table
        // dijkstra
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] t : times) {
            map.computeIfAbsent(t[0], s -> new ArrayList<int[]>()).add(new int[] {t[1], t[2]});
        }
        boolean[] visited = new boolean[n+1];
        
        PriorityQueue<int[]> pq =  new PriorityQueue<>( (a, b) -> (a[0]-b[0]) );
        pq.offer(new int[] {0, k});
        
        int rets = 0;
        while (!pq.isEmpty()) {
            int[] curnode = pq.poll();
            if (visited[curnode[1]]) continue;
            visited[curnode[1]] = true;
            rets = Math.max(rets, curnode[0]);
            //System.out.println(curnode[1] + " " + curnode[0]);
            if (!map.containsKey(curnode[1])) continue;
            for (int[] next : map.getOrDefault(curnode[1], null)) {
                //System.out.println(" next -> " + next[0]);
                pq.offer(new int[] {curnode[0]+next[1], next[0]});
            }
        }
        
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) return -1;
        }
        return rets;
    }
}
