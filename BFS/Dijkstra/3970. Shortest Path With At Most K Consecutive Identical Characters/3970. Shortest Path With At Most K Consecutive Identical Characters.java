class Solution {
    // dijkstra
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            g[u].add(new int[]{v, w});
        }

        int[][] dis = new int[n][k+2];
        for (int[] d : dis) {
            Arrays.fill(d, Integer.MAX_VALUE/2);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1]-b[1]));
        pq.offer(new int[]{0,0,1}); // {v, w, cnt}
        dis[0][1] = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curu = cur[0];
            int curw = cur[1];
            int curcnt = cur[2];
            if (curcnt > k) continue;
            if (curu == n-1) return curw;

            for (int[] nxt : g[curu]) {
                int nxtw = curw + nxt[1];
                int nxtv = nxt[0];
                int nxtcnt = 1;
                if (labels.charAt(nxtv) == labels.charAt(curu)) {
                    nxtcnt += cur[2];
                }
                if (nxtw < dis[nxtv][nxtcnt]) {
                    dis[nxtv][nxtcnt] = nxtw;
                    pq.offer(new int[]{nxtv, nxtw, nxtcnt});
                }
            }
        }

        return -1;
    }
}

// [node, count]: state
// dis[x][cnt] as the shortest distance from node 0 to node x where the path ends with cnt consecutive identical characters.
// [x, cnt] -> {nxt, cnt?} : label[x] = label[nxt] -> cnt+1  else cnt = 1
// if current cnt > k , ignore this path, and cnt < k then max (cnt+1) <= k
