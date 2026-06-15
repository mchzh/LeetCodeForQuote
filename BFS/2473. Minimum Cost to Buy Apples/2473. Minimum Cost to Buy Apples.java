class Solution {
    public long[] minCost(int n, int[][] roads, int[] appleCost, int k) {
        long[] rets = new long[n];
        Arrays.fill(rets, Integer.MAX_VALUE);
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < roads.length; i++) {
            int[] cur = roads[i];
            int a = cur[0], b = cur[1], c = cur[2];
            map.computeIfAbsent(a, t -> new ArrayList<>()).add(new int[]{b, c});
            map.computeIfAbsent(b, t -> new ArrayList<>()).add(new int[]{a, c});
        }

        for (int i = 1; i <= n; i++) {
            //rets[i] = (long)appleCost[i];
            // Dijkstra
            boolean[] visited = new boolean[n+1];
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
            pq.offer(new int[]{0, i});
            int[] dist = new int[n+1];
            Arrays.fill(dist, Integer.MAX_VALUE/2);
            dist[i] = 0;
            

            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                int d = cur[0];
                int node = cur[1];
                if (visited[node]) continue;
                rets[i-1] = Math.min(rets[i-1], (long)(k+1)*(long)d + (long)appleCost[node-1]);
                visited[cur[1]] = true;
                if (!map.containsKey(cur[1])) continue;

                for (int[] next : map.get(cur[1])) {
                    if (visited[next[0]]) continue;
                    int nextnode = next[0];
                    int nextcost = next[1];
                    dist[nextnode] = Math.min(dist[nextnode], nextcost+dist[node]);
                    pq.offer(new int[]{dist[nextnode], nextnode});
                }
            }

        }
        return rets;
    }
}
