class Solution {
    int mod = (int)(1e9+7);
    int[] dp;
    public int countRestrictedPaths(int n, int[][] edges) {
        int[] dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] e : edges) {
            map.computeIfAbsent(e[0], s -> new ArrayList<int[]>()).add(new int[] {e[1], e[2]});
            map.computeIfAbsent(e[1], s -> new ArrayList<int[]>()).add(new int[] {e[0], e[2]});
        }
        boolean[] visited = new boolean[n+1];
        
        PriorityQueue<int[]> pq =  new PriorityQueue<>( (a, b) -> (a[0]-b[0]) );
        pq.offer(new int[] {0, n});
    
        while (!pq.isEmpty()) {
            int[] curnode = pq.poll();
            if (visited[curnode[1]]) continue;
            visited[curnode[1]] = true;
            dis[curnode[1]] = curnode[0];
            
            if (!map.containsKey(curnode[1])) continue;
            for (int[] next : map.getOrDefault(curnode[1], null)) {
                pq.offer(new int[] {curnode[0]+next[1], next[0]});
            }
        }
        
        
        boolean[] visited1 = new boolean[n+1];
        return dfsdp(map, 1, n, dis, visited1);
    }
    private int dfsdp(Map<Integer, List<int[]>> map, int start, int end, int[] dis, boolean[] visited) {
        if (start == end) {
            return 1;
        }
        if (dp[start] != -1) return dp[start];
        
        int ans = 0;
        visited[start] = true;
        for (int[] next : map.get(start)) {
            if (visited[next[0]]) continue;
            if (dis[start] <= dis[next[0]]) continue;
            ans = (ans +dfsdp(map, next[0], end, dis, visited))%mod;
        }
        visited[start] = false;
        
        return dp[start] = ans;
    }
}
