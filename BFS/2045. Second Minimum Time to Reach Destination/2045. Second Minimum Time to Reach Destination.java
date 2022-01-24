class Solution {
    // BFS
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        // create adjacent table
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] e : edges) {
            int a= e[0], b = e[1];
            graph.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            graph.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
            //graph.computeIfAbsent();
        }
        
        Queue<int[]> q = new LinkedList<>(); //pair -> {node, time}
        int[] visited = new int[n+1];
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);
        q.offer(new int[] {1, 0});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int endtime = cur[1];
            
            if (!graph.containsKey(node)) continue;
            int tt = 0;
            int round = endtime/change;
            if (round%2 == 0) {
                tt = endtime+time;
            } else {
                tt = change*(round+1) + time; // from red to green stage
            }
            for (int nxt : graph.get(node)) {
                if (visited[nxt] < 2 && dist[nxt] < tt) {
                    visited[nxt]++;
                    dist[nxt] = tt;
                    q.offer(new int[] {nxt, tt});
                }
                if (nxt == n && visited[nxt] == 2) {
                    return tt;
                }
            }
        }
        return -1;
    }
}
