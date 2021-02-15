class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        int[] degrees = new int[n+1];
        int[][] connect = new int[n+1][n+1];
        List[] next = new List[n+1];
        for (int a = 0; a <= n; a++) {
            next[a] = new ArrayList<Integer>();
        }
        
        for (int[] e : edges) {
            int x = Math.min(e[0], e[1]);
            int y = Math.max(e[0], e[1]);
            degrees[e[0]] += 1;
            degrees[e[1]] += 1;
            connect[e[0]][e[1]] = 1;
            connect[e[1]][e[0]] = 1;
            next[x].add(y);
        }
        
        int rets = Integer.MAX_VALUE;
        for (int a = 1; a <= n; a++) {
            for (int j = 0; j < next[a].size(); j++) {
                for (int k = j+1; k < next[a].size(); k++) {
                    int b = (int)next[a].get(j), c = (int)next[a].get(k);
                    if (connect[b][c] == 1) rets = Math.min(rets, degrees[a]+degrees[b]+degrees[c]-6);
                }
            }
        }
        
        return rets == Integer.MAX_VALUE ? -1 : rets;
    }
}
