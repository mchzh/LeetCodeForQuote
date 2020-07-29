class Solution {
//     Dijkstra's Algorithm Complexity
// Time Complexity: O(E Log V)

// where, E is the number of edges and V is the number of vertices.

// Space Complexity: O(V)
    // floyd : O(n^3)
    public int networkDelayTime(int[][] times, int N, int K) {
        int[][] dp = new int[N+1][N+1];
        for (int[] d : dp) {
            Arrays.fill(d, Integer.MAX_VALUE/2);
        }
        for (int[] t : times) {
            dp[t[0]][t[1]] = t[2];
        }
        for (int i = 0; i <= N; i++) {
            dp[i][i] = 0;
        }
        
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }
        int ret = 0;
        for (int i = 1; i <= N; i++) {
            ret = Math.max(ret, dp[K][i]);
        }
        return ret == Integer.MAX_VALUE/2 ? -1 : ret;
    }
    public int networkDelayTimeDijk(int[][] times, int N, int K) {
        // the shortest path of reaching the last node
        // visited
        Map<Integer, Set<int[]>> map = new HashMap<>();
        boolean[] visited = new boolean[N+1];
        for (int[] t : times) {
            map.computeIfAbsent(t[0], k -> new HashSet<>()).add(new int[] {t[2], t[1]});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> (a[0]-b[0]) );
        
        pq.offer(new int[] {0, K});
        
        
        int pathSize = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (visited[cur[1]]) continue;
            visited[cur[1]] = true;
            N--;
            pathSize = cur[0];
            if (N == 0) return pathSize;
            for (int[] next : map.getOrDefault(cur[1], new HashSet<int[]>())) {
                if (visited[next[1]]) continue;
                pq.offer(new int[] {cur[0] + next[0], next[1]});
            }
        }
        return N == 0 ? pathSize : -1;
    }
}

// Floyd
// dp[i][j]
// k = 1, 2, 3, --- N;
// dp[i][j] = ? dp[i][k] + dp[k][j]

// for (int k = 1; k <= N; k++) {
//     for (int i = 1; i <= N; i++) {
//         for (int j = 1; j <= N; j++) {
//             dp[i][j] = min(dp[i][j], dp[i][k] + dp[k][j]);
//         }
//     }
// }
