class Solution {
    // after union find and the group number is one
    // otherwise, more than one means not all computer conntected so return -1
    class UnionFind {
        int[] parent;
        int group;
        int duplicateedge;
        public UnionFind(int N) {
            parent = new int[N];
            group = N;
            duplicateedge = 0;
            
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }
        }
        
        public void union(int x, int y) {
            x = find(x);
            y = find(y);
            if (x != y) group--;
            else duplicateedge++;
            if (x < y) {
                parent[x] = y;
            } else {
                parent[y] = x;
            }
        }
        
        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
    
    public int makeConnected(int n, int[][] connections) {
        UnionFind uf = new UnionFind(n);
        
        for (int[] connection : connections) {
            uf.union(connection[0], connection[1]);
        }
        
        return uf.duplicateedge >= uf.group-1 ? uf.group-1 : -1;
    }
}

/*class Solution {
    int[] parents;
    public int makeConnected(int n, int[][] connections) {
        parents = new int[n];
        for(int i=0; i<n; i++) {
            parents[i] = i;
        }
        int connected = n, extra=0;
        for(int[] connection : connections) {
            if(this.union(connection[0], connection[1])) {
                connected--;
            } else {
                extra++;
            }
        }
        if(connected-extra <= 1) {
            return connected-1;
        }
        return -1;
    }
    
    private boolean union(int x, int y) {
        int setX = find(x);
        int setY = find(y);
        if(setX != setY) {
            parents[setY] = setX;
            return true;
        }
        return false;
    }
    
    private int find(int num) {
        if(parents[num] != num) {
            parents[num] = find(parents[num]);
        }
        return parents[num];
    }
}*/
