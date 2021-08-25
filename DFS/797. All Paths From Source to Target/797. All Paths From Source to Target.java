class Solution {
    List<List<Integer>> rets = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(0, n-1, list, graph);
        return rets;
    }
    private void dfs(int curp, int endp, List<Integer> list, int[][] graph) {
        if (curp == endp) {
            rets.add(new ArrayList<>(list));
            return;
        }

        for (int next : graph[curp]) {
            list.add(next);
            dfs(next, endp, list, graph);
            list.remove(list.size()-1);
        }
        // if (map.containsKey(curp)) {
        //     list.add(curp);
        //     visited[curp] = true;
        //     for (int next : map.get(curp)) {
        //         if (visited[next] == true) continue;
        //         dfs(map, next, endp, list, visited);
        //     }
        //     list.remove(list.size()-1);
        //     visited[curp] = false;
        // }
        
    }
}
