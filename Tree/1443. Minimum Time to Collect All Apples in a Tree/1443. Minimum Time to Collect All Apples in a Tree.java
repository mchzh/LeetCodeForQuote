class Solution {
    int times = 0;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        // undirected graph
        // check whether this edge use or not
        // build graph and dfs + backtracking
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] e : edges) {
            map.computeIfAbsent(e[0], k -> new HashSet<>()).add(e[1]);
            map.computeIfAbsent(e[1], k -> new HashSet<>()).add(e[0]);
        }
        boolean[] visited = new boolean[n];
        dfs(map, 0, hasApple, visited);
        return times;
    }
    private boolean dfs(Map<Integer, Set<Integer>> map, int pos, List<Boolean> hasApple, boolean[] visited) {
        if (map.getOrDefault(pos, null) == null) return hasApple.get(pos);
        boolean isApple = false;
        //System.out.println(" cur pos -> " + pos + " : is Null map -> " + map.getOrDefault(pos, null));
        visited[pos] = true;
        for (int next : map.getOrDefault(pos, null)) {
            if (visited[next]) continue;
            if (dfs(map, next, hasApple, visited)) {
                times += 2;
                isApple = true;
            }
        }
        visited[pos] = false;
        return isApple || hasApple.get(pos);
    }
}

/*class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<Integer>[] graph = new List[n];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        
        for(int[] i :edges){
            graph[i[0]].add(i[1]);
            graph[i[1]].add(i[0]);
        }
        
        boolean[] visited=new boolean[n];
       return compute(0,graph,hasApple,visited);  
    }
    
    public int compute(int curr, List<Integer>[] graph, List<Boolean> hasApple, boolean[] visited){
        int res=0;
        if(!visited[curr]){
            visited[curr]=true;
            
            for(int i : graph[curr]){
                if(visited[i])continue ;
                
                res+=compute(i,graph,hasApple,visited);
            }
            
            if(curr!=0 && (hasApple.get(curr) || res>0))res+=2;
        }
        return res;
    }
}*/
