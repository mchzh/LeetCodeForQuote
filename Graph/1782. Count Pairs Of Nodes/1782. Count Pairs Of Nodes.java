class Solution {
    // https://leetcode.com/problems/count-pairs-of-nodes/discuss/1096432/Java-or-Two-Steps-or-O(NlgN-%2B-Q(N%2BE))
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        int[] degree = new int[n];
        Map<Integer, Integer> occurrence = new HashMap<>();
        for (int[] e : edges) {
            degree[--e[0]]++;
            degree[--e[1]]++;
            if (e[0] > e[1]) {
                int temp = e[0];
                e[0] = e[1];
                e[1] = temp;
            }
            
            int cur = e[0]*20000+e[1];
            occurrence.put(cur, occurrence.getOrDefault(cur, 0) + 1); // pair cnt
        }
        
        // two pointer to get the x + y > query
        int[] sorted = degree.clone();
        Arrays.sort(sorted);
        int[] rets = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int ans = 0;
            
            for (int l = 0, r = n-1; l < r;) {
                if (sorted[l] + sorted[r] > queries[i]) {
                    ans += r-l;
                    r--;
                } else {
                    l++;
                }
            }
            
            // cal the occurence
            for (int k : occurrence.keySet()) {
                int a = k/20000;
                int b = k%20000;
                if (degree[a] + degree[b] > queries[i] && degree[a] + degree[b] - occurrence.get(k) <= queries[i]) ans--;
            }
            rets[i] = ans;
        }
        return rets;
    }
}

// degree[x]+degree[y]-occurance(x,y)
// degree[x] + degree[y] > query

/*class Solution {
    static int MOD = 1_000_000_007;
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        List<Map<Integer, Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) adj.add(new HashMap<>());
        int[] deg = new int[n];
        for (int[] e : edges) {
            e[0]--; e[1]--;
            int u = Math.min(e[0], e[1]);
            int v = Math.max(e[0], e[1]);
            adj.get(u).put(v, adj.get(u).getOrDefault(v, 0) + 1);
            deg[u]++; deg[v]++;
        }
        int[] sorted = new int[n];
        System.arraycopy(deg, 0, sorted, 0, n);
        Arrays.sort(sorted);
        int[] ans = new int[queries.length];
        for (int qi = 0; qi < queries.length; qi++) {
            int q = queries[qi];
            long count = 0;
            int l = 0;
            int r = n-1;
            while (l < r) {
                if (sorted[l] + sorted[r] > q) {
                    count += r-1-l+1;
                    r--;
                } else {
                    l++;
                }
            }
            for (int a = 0; a < n; a++) {
                for (Map.Entry<Integer, Integer> bf : adj.get(a).entrySet()) {
                    int b = bf.getKey();
                    int f = bf.getValue();
                    if (deg[a] + deg[b] > q && deg[a] + deg[b] - f <= q) count--;
                }
            }
            ans[qi] = (int) (count % MOD);
        }
        return ans;
    }
}*/
