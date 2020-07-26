class Solution {
    class Pair {
        int node;
        int state;
        public Pair(int node, int state) {
            this.node = node;
            this.state = state;
        }
    }
    public int shortestPathLength(int[][] graph) {
        int N = graph.length;
        //bFs
        int finalState = 0;
        for (int i = 0; i < N; i++) {
            finalState |= 1<<i;
        }
        
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, Set<Integer>> visited = new HashMap<>();
        for (int i = 0; i < N; i++) {
            queue.offer(new Pair(i, 1<<i));
            visited.computeIfAbsent(i, k -> new HashSet<>()).add(1<<i);
        }
        
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair p = queue.poll();
                
                //if (p.state == finalState) return step;
                
                for (int next : graph[p.node]) {
                    int nextState = p.state | (1<<next);
                    if (nextState == finalState) return step;
                    
                    if (!visited.get(next).contains(nextState)) {
                        queue.offer(new Pair(next, nextState));
                        visited.get(next).add(nextState);
                    }
                }
            }
        }
        
        return 0;
    }
}
