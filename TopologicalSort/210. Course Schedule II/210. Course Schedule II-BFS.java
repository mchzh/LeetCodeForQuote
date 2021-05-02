class Solution {
    // bfs or dfs
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int[] p : prerequisites) {
            int a = p[0], b = p[1];
            map.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
            indegree[a]++;
        }
        
        int[] rets = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.offer(i);
        }
        
        int idx = 0;
        int count = numCourses;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                rets[idx++] = cur;
                count--;
                if (!map.containsKey(cur)) continue;
                for (int next : map.get(cur)) {
                    indegree[next]--;
                    if (indegree[next] == 0) q.offer(next);
                }
            }
        }
        return count == 0 ? rets : new int[] {};
    }
}
