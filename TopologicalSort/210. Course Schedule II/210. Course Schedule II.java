class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            map.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
            indegree[edge[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            list.add(cur);
            
            if (!map.containsKey(cur)) continue;
            for (int next : map.getOrDefault(cur, null)) {
                indegree[next]--;
                if (indegree[next] ==0) {
                    queue.offer(next);
                }
            }
        }
        int[] rets = new int[list.size()];
        for (int i= 0; i < list.size(); i++) {
            rets[i] = list.get(i);
        }
        return list.size() == numCourses ? rets : new int[] {};
    }
}
