class Solution {
    // https://leetcode.com/problems/parallel-courses/discuss/344808/Java-Topological-Sort-%2B-BFS-w-comment-and-analysis.
    // toplogical sort + BFS or DFS
    public int minimumSemesters(int N, int[][] relations) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        int[] indegree = new int[N + 1];
        for (int[] r : relations) {
            g.computeIfAbsent(r[0], k -> new ArrayList<>()).add(r[1]);
            indegree[r[1]]++;
        }
        
        // BFS
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] != 0) continue;
            queue.offer(i);
        }
        
        int semester = 0;
        while (!queue.isEmpty()) {
            for (int sz = queue.size()-1; sz >= 0; sz--) {
                int cur = queue.poll();
                N--;
                if (!g.containsKey(cur)) continue;
                // indegree reduce one
                for (int next : g.get(cur)) {
                    indegree[next]--;
                    if (indegree[next] == 0) queue.offer(next);
                }
            }
            semester++;
        }
        return N == 0 ? semester : -1;
    }
}
// time complexity: O(V+E)
