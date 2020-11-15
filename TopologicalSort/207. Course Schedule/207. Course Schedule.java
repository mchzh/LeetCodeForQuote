class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // create directed graph
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            map.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
            indegree[edge[0]] += 1;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i <numCourses; i++ ) {
            if (indegree[i] == 0) queue.offer(i);
        }
        
        int count = numCourses;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            count--;
            
            if (!map.containsKey(cur)) continue;
            for (int next : map.getOrDefault(cur, null)) {
                indegree[next] -= 1;
                if (indegree[next] == 0) queue.offer(next); 
            }
        }
        
        return count == 0;
    }
    
}

// toplogical sort
// BFS / DFS
// 0->1->2
