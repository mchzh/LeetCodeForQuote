class Solution {
    int n;
    Set<Integer>[] g;
    public int findShortestCycle(int n, int[][] edges) {
        this.n = n;
        g = new HashSet[n];
        for (int i = 0; i < n; i++) {
            g[i] = new HashSet<>();
        }

        // create graph
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }

        // loop every edge
        int rets = Integer.MAX_VALUE;
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            g[a].remove(b);
            g[b].remove(a);
            rets = Math.min(rets, bfs(a, b));
            g[a].add(b);
            g[b].add(a);
        }
        if (rets == Integer.MAX_VALUE) return -1;
        return rets + 1;
    }
    private int bfs(int a, int b) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.offer(a);
        visited[a] = true;
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i< size; i++) {
                int cur = q.poll();
                if (cur == b) return step;

                for (int next : g[cur]) {
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
// delete a - b edge then check from a to b the minmum path with BFS
