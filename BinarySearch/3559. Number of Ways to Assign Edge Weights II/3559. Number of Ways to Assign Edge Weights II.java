class Solution {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    int maxn = 100005;
    int loginn = 17;
    int[] deep;
    int[][] up;
    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;
        deep = new int[maxn];
        up = new int[maxn][loginn+1];
        for (int[] e : edges) {
            int a = e[0];
            int b = e[1];
            adj.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            adj.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }
        deep[1] = 0;
        dfs(1, 1);

        // set parent path
        for(int k = 1; k <= loginn; k++) {
            for(int v = 1; v <= n; v++) {
                up[v][k] = up[up[v][k-1]][k-1]; // /2*2
            }
        }
        
        long mod = (long)(1e9+7);
        long[] power = new long[n+1];
        power[0] = 1;
        for (int i=1; i<=n; i++)
            power[i] = power[i-1]*2%mod;

        int[] rets = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int u = q[0], v = q[1];
            int curlen = dist(u, v);
            
            if (curlen == 0) {
                rets[i] = 0;
            } else {
                rets[i] = (int)power[curlen-1];
            }
            
        }
        return rets;
    }
    private void dfs(int cur, int parent) {
        up[cur][0] = parent;
        // next
        if (!adj.containsKey(cur)) return;
        for (int next : adj.get(cur)) {
            if (next == parent) continue;
            deep[next] = deep[cur] + 1;
            dfs(next, cur);
        }
    }
    private int dist(int a, int b) {
        int c = lca(a, b);
        return deep[a] + deep[b] - 2*deep[c];
    }
    private int lca(int a, int b) {
        // deep mean from root to this points
        if (deep[a] < deep[b]) {
            int temp = a;
            a = b; 
            b = temp;
        }
        int diff = deep[a] - deep[b];
        
        for (int k = 0; k <= loginn; k++) {
            //System.out.println("lca binary -> " + (diff & (1<<k)) + " : " + k + " : " + diff);
            if ((diff & (1<<k)) > 0) {
                // diff = a0*2^0 + a1*2^1 + ...
                a = up[a][k];
            }
        }
        
        if (a == b) return a;
        for(int k = loginn; k >= 0; k--){
            if(up[a][k] != up[b][k]){
                a = up[a][k];
                b = up[b][k];
            }
        }
        return up[a][0];
    }
}
