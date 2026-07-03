class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        // adjacent list to save DAG: key is leftnode, value is [rightnode, weight]
        int n = online.length;
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // create DAG
        // binary search range
        int left = Integer.MAX_VALUE;
        int right = 0;
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            if (!online[u] || !online[v]) {
                continue;
            }
            graph.get(u).add(new int[]{v, w});
            left = Math.min(left, w);
            right = Math.max(right, w);
        }

        while (left < right) {
            int mid = right - (right-left)/2;
            if (check(graph, mid, k, n)) {
                left = mid;
            } else {
                right = mid-1;
            }
        }
        if (!check(graph, left, k, n)) return -1;
        return left;
    }
    private boolean check(List<List<int[]>> g, int mid, long k, int n) {
        long[] dis = new long[n];
        Arrays.fill(dis, Long.MAX_VALUE);
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0])); // 0: distance, 1, node
        dis[0] = 0;
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int u = (int)cur[1];
            if (d > k) {
                return false;
            }
            if (u == n-1) {
                return true;
            }
            if (d > dis[u]) {
                continue;
            }

            for (int[] next : g.get(u)) {
                int v = next[0];
                int w = next[1];

                if (w < mid) {
                    continue;
                }
                // update dis for next node
                if (dis[v] > dis[u] + w) {
                    dis[v] = dis[u] + w;
                    pq.offer(new long[]{dis[v], v});
                }
            }
        }
        return false;
    }
}
