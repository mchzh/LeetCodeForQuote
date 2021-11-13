class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        int N = n;
        List<int[]>[] graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<int[]>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(new int[] {edge[1], 0, 0});
            graph[edge[1]].add(new int[] {edge[0], 0, 0});
        }
        
        boolean[] visited = new boolean[N];
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            // backtracking's dfs
            res[i] = dfs(graph, i, visited)[0];
        }
        return res;
    }
    public int[] dfs(List<int[]>[] graph, int cur, boolean[] visited) {
        visited[cur] = true;
        int sum = 0;
        int num = 1;
        for (int[] child : graph[cur]) {
            if (!visited[child[0]]) {
                if (child[1] == 0 && child[2] == 0) {
                    int[] temp = dfs(graph, child[0], visited);
                    child[1] = temp[0];
                    child[2] = temp[1];
                }
                sum += child[1] + child[2];
                num += child[2];
            }
        }
        visited[cur] = false;
        return new int[] {sum, num};
    }
}
