class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] p : prerequisites) {
            int a = p[0], b = p[1];
            map.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }
        int[] visited = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, map, visited)) return false;
        }
        return true;
    }
    private boolean dfs(int cur, Map<Integer, List<Integer>> map, int[] visited) {
        if (visited[cur] == 1) return true;
        
        visited[cur] = 2;
        if (!map.containsKey(cur)) {
            visited[cur] = 1;
            return true;
        }
        //if () return ;
        //System.out.println(cur);
        for (int next : map.getOrDefault(cur, null)) {
            if (visited[next] == 1) continue;
            if (visited[next] == 2) return false;
            if (!dfs(next, map, visited)) return false;
        }
        visited[cur] = 1;
        return true;
    }
}
