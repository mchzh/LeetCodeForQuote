class Solution {
    Set<Integer>[] graph;
    int n;
    public int findShortestCycle(int n, int[][] edges) {
        graph = new HashSet[n];
        this.n = n;
        for (int i = 0; i < n; i++) {
            graph[i] = new HashSet<>();
        }
        // create graph
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        // tranverse edge
        int rets = Integer.MAX_VALUE;
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            graph[a].remove(b);
            graph[b].remove(a);
            rets = Math.min(rets, bfs(a, b));
            graph[a].add(b);
            graph[b].add(a);
        }
        if (rets  == Integer.MAX_VALUE) return -1;
        return rets+1;
    }

    private int bfs(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        visited[start] = true;
        q.offer(start);

        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (cur == end) {
                    return step;
                }

                for (int next : graph[cur]) {
                    if (visited[next]) continue;
                    q.offer(next);
                    visited[next] = true;
                }
            }
            step++;
        }
        return Integer.MAX_VALUE;
    }
}
//  create graph
// when visit one edge, to remove this edge between a and b then check whether exist another path from a to b with BFS
