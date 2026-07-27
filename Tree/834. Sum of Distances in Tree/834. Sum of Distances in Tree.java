class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    int[] subsize = new int[30005];
    boolean[] visited = new boolean[30005];
    int[] rets;
    int n;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.n = n;
        rets = new int[n];
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            graph.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            graph.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }

        visited[0] = true;
        dfs(0);
        for (int i = 1; i < 30005; i++) {
            visited[i] = false;
        }
        rets[0] = dfs2(0);

        for (int i = 1; i < 30005; i++) {
            visited[i] = false;
        }
        dfs3(0);

        return rets;
    }
    private int dfs(int cur) {
        // how many node size on current subtree
        int sum = 1;
        if (graph.containsKey(cur)) {
            for (int x : graph.get(cur)) {
                if (visited[x]) continue;
                visited[x] = true;
                sum += dfs(x);
            }
        }
        
        subsize[cur] = sum;
        return sum;
    }

    private int dfs2(int cur) {
        // how many node size on current subtree
        int sum = 0;
        if (graph.containsKey(cur)) {
            for (int x : graph.get(cur)) {
                if (visited[x]) continue;
                visited[x] = true;
                sum += dfs2(x);
            }
        }
        
        sum += subsize[cur] - 1;
        return sum;
    }

    private void dfs3(int cur) {
        
        if (graph.containsKey(cur)) {
            for (int x : graph.get(cur)) {
                if (visited[x]) continue;
                visited[x] = true;
                int b = subsize[x];
                int a = n - b;
                rets[x] = rets[cur] + a - b;
                dfs3(x);
            }
        }
    }
}
