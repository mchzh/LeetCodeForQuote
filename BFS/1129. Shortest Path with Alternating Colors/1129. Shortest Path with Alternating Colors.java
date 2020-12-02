class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        //create graph and bfs
        // two demension visited definition
        int[] rets = new int[n];
        Arrays.fill(rets, -1);
        rets[0] = 0;
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] r : red_edges) {
            map.computeIfAbsent(r[0], k -> new ArrayList<>()).add(new int[] {r[1], 0});
        }
        for (int[] b : blue_edges) {
            map.computeIfAbsent(b[0], k -> new ArrayList<>()).add(new int[] {b[1], 1});
        }
        
        // bfs;
        boolean[][] visited = new boolean[n][2];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, -1});
        visited[0][0] = true;
        visited[0][1] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (!map.containsKey(cur[0])) continue;
                // add next point
                for (int[] next : map.get(cur[0])) {
                    if (visited[next[0]][next[1]]) continue;
                    if (next[1] != cur[1]) {
                        queue.offer(new int[] {next[0], next[1]});
                        visited[next[0]][next[1]] = true;
                        if (rets[next[0]] == -1) rets[next[0]] = level;
                    }
                }
            }
        }
        return rets;
    }
}
