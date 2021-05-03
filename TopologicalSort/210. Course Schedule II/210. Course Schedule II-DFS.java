class Solution {
    // bfs or dfs
    Map<Integer, List<Integer>> map;
    int[] visited;
    int[] rets;
    boolean isValid = true;
    int index;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        map = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int[] p : prerequisites) {
            int a = p[0], b = p[1];
            map.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            indegree[a]++;
        }
        visited = new int[numCourses];
        
        rets = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) dfs(i);
        }
        return isValid ? rets : new int[0];
    }
    private void dfs(int cur) {
        visited[cur] = 2;
        for (int next : map.getOrDefault(cur, new ArrayList<>())) {
            if (visited[next] == 0) dfs(next);
            else if (visited[next] == 2) isValid = false;
        }
        rets[index++] = cur;
        visited[cur] = 1;  
    }
}
