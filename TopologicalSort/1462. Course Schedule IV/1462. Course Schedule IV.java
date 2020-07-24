class Solution {
    // reverse the adjacent relationship
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        Map<Integer, Set<Integer>> toplogG = new HashMap<>();
        Map<Integer, Set<Integer>> reverse = new HashMap<>();
        int[] indegrees = new int[n];
        for (int[] pre : prerequisites) {
            toplogG.computeIfAbsent(pre[0], k -> new HashSet<>()).add(pre[1]);
            
            indegrees[pre[1]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            reverse.computeIfAbsent(i, k -> new HashSet<>()).add(i);
            if (indegrees[i] != 0) continue;
            queue.offer(i);
        }
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            
            for (int next : toplogG.getOrDefault(cur, new HashSet<>())) {
                // get child -> parent set
                // System.out.println(next);
                for (int parent : reverse.getOrDefault(cur, new HashSet<>())) {
                    reverse.get(next).add(parent);
                }
                indegrees[next]--;
                if (indegrees[next]  == 0) {
                    queue.offer(next);
                }
            }
        }
        
        List<Boolean> rets = new ArrayList<>();
        for (int[] query : queries) {
            if (reverse.get(query[1]).contains(query[0])) rets.add(true);
            else rets.add(false);
        }
        return rets;
    }
}
