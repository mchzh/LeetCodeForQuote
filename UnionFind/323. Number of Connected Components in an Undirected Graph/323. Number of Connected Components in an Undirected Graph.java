class Solution {
    // union find
    class UF {
        int[] parent;
        int count;
        public UF(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
            count = n;
        }
        
        public void union(int x, int y) {
            x = find(x);
            y = find(y);
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
        
        public int find(int c) {
            if ( c != parent[c] ) {
                parent[c] = find(parent[c]);
            }
            return parent[c];
        }
    }
    
    public int countComponents(int n, int[][] edges) {
        UF uf = new UF(n);
        
        for (int[] e : edges) {
            int a = e[0];
            int b = e[1];
            if (uf.find(a) != uf.find(b)) {
                uf.union(a, b);
                uf.count--;
            }
        }
        return uf.count;
    }
}
