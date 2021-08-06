class Solution {
    // dfs with state
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int finalState = 0;
        boolean[][] visited = new boolean[n][(1<<n)];
        Queue<int[]> q = new LinkedList<>(); // node state
        for (int i = 0; i < n; i++) {
            finalState |= (1<<i);
            q.offer(new int[] {i, (1<<i)});
            visited[i][(1<<i)] = true;
        }

        int step = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            step++;

            while(size-- > 0) {
                int[] cur = q.poll();
                int curnode = cur[0];
                int curstate = cur[1];
                for (int nextnode : graph[curnode]) {
                    int nextstate = curstate | (1<<nextnode);
                    if (nextstate == finalState) return step+1;

                    if (visited[nextnode][nextstate]) continue;
                    q.offer(new int[] {nextnode, nextstate});
                    visited[nextnode][nextstate] = true;
                }
            }
        }
        return 0;
    }
}
// remove duplicate with state
// 0 -> 1 -> 2
//        -> 3
//        -> 4
//   -> 2 -> 1

//        c -> a -> b
//             |
//             ^
//             d
