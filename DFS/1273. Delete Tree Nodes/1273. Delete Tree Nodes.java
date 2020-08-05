class Solution {
    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        boolean[] visited = new boolean[nodes];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < nodes; i++) {
            if (parent[i] == -1) continue;
            map.computeIfAbsent(parent[i], k -> new HashSet<>()).add(i);
        }
        
        // recursion get sub-tree sum
        dfs(map, 0, visited, value);
        setSubNodeStatus(map, 0, false, visited);
        int count = 0;
        for (int i = 0; i < nodes; i++) {
            if (visited[i] == true) continue;
            count++;
        }
        return count;
    }
    private int dfs(Map<Integer, Set<Integer>> map, int curNode, boolean[] visited, int[] value) {
        if (!map.containsKey(curNode)) {
            if(value[curNode] == 0) visited[curNode] = true;
            return value[curNode];
        }
        
        int sum = value[curNode];
        for (int next : map.get(curNode)) {
            sum += dfs(map, next, visited, value);
        }
        if (sum == 0) visited[curNode] = true;
        return sum;
    }
    
    private void setSubNodeStatus(Map<Integer, Set<Integer>> map, int curNode, boolean parentStatus, boolean[] visited) {
        if (!map.containsKey(curNode)) {
            if (parentStatus == true) visited[curNode] = parentStatus;
            return;
        }
        
        if (parentStatus == true) visited[curNode] = parentStatus;
        for (int next : map.get(curNode)) {
            setSubNodeStatus(map, next, visited[curNode], visited);
        }
    }
}
