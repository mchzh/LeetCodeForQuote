class Solution {
    // BFs + state compression: 
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int finalState = (1<<n)-1;
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][(1<<n)];
        for (int i = 0; i < n; i++) {
            queue.offer(new int[] {i, (1<<i)});
            visited[i][1<<i] = true;
        }
        
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int curnode = cur[0];
                int curstate = cur[1];
                
                for (int nextnode : graph[curnode]) {
                    int nextstate = (curstate|(1<<nextnode));
                    if (nextstate == finalState) return step;
                    if (!visited[nextnode][nextstate]) {
                        queue.offer(new int[] {nextnode, nextstate});
                        visited[nextnode][nextstate] = true;
                    }
                }
            }
        }
        
        return 0;
    }
}

// C - A - B
//     |
//     D
