class Solution {
    // topological sort
    List<Integer> rets = new ArrayList<>();
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (dfs(graph, i, visited)) rets.add(i);
        }
        //Collections.sort(rets);
        return rets;
    }
    private boolean dfs(int[][] graph, int pos, int[] visited) {
        if (visited[pos] == 2) return true;
        if (visited[pos] == 1) return false;

        visited[pos] = 1;
        for (int next : graph[pos]) {
            if (!dfs(graph, next, visited)) return false;
        }
        visited[pos] = 2;
        return true;
    }
}
