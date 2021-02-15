class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        Arrays.fill(visited, -1);
        for (int i = 0; i < n; i++) {
            if (visited[i] != -1) continue;
            
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[] {i, 0}); // 0 represent group a, 1 represent group b
            visited[i] = 0;
            
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                for (int next : graph[cur[0]]) {
                    if (visited[next] != -1) {
                        if (visited[next] == cur[1]) return false;
                        //q.offer();
                    } else {
                        visited[next] = 1-cur[1];
                        q.offer(new int[] {next, visited[next]});
                    }
                    
                }
            }
        }
        return true;
    }
}
