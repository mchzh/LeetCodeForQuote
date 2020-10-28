class Solution {
    // https://leetcode.com/problems/swim-in-rising-water/discuss/118204/Java-DFS-and-Union-Find
    // union find efficiency not so good, consider BFS
    class UF {
        int[] parent;
        public UF(int N) {
            parent = new int[N];
            
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }
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
        
        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
    // BFS or union find
    public int swimInWater(int[][] grid) {
        int N = grid.length;
        UF uf = new UF(N*N);
        int time = 0;
        while ( uf.find(0) != uf.find(N*N-1) ) {
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[i][j] > time) continue;
                    if (i < N-1 && grid[i+1][j] <= time) uf.union( i*N+j, (i+1)*N+j );
                    if (j < N-1 && grid[i][j+1] <= time) uf.union( i*N+j, i*N+j+1 );
                }
            }
            time++;
        }
        return time-1;
    }
}
