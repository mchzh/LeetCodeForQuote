class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // build graph + dfs with height array
        // bfs + indegree
        if (n == 1) return Collections.singletonList(0);
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> removed = new HashSet<>();
        for (int i = 0; i < n; i++) removed.add(i);
        
        int[] indegrees = new int[n];
        for (int[] e : edges) {
            map.computeIfAbsent(e[0], k -> new HashSet<>()).add(e[1]);
            map.computeIfAbsent(e[1], k -> new HashSet<>()).add(e[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (map.get(i) != null && map.get(i).size() != 1) continue;
            queue.offer(i);
        }
        
        while (removed.size() > 2) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                removed.remove(cur);
                for (int next : map.get(cur)) {
                    map.get(next).remove(cur);
                    if (map.get(next).size() == 1) {
                        queue.offer(next);
                    }
                }
            }
            
        }
        return new ArrayList<Integer>(removed);
    }
}

/*class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        List<Integer> leaves = new ArrayList<>();
        List<Set<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < n; ++i) {
            if (adj.get(i).size() == 1) leaves.add(i);
        }
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int t = adj.get(i).iterator().next();
                adj.get(t).remove(i);
                if (adj.get(t).size() == 1) newLeaves.add(t);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}*/
