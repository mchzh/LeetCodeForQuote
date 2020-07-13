class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) return;
        // consider union find
        // tranverse 2D matrix and when element is 'O': 1. it is a boundary element to uinon it to dymm node; 2. otherwise union it and 'O' element of its four direction
        UnionFind uf = new UnionFind(board);
        int row = board.length, col = board[0].length;
        int dummyNode = row*col;
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'X') continue;
                // 1. in boundary
                if (i == 0 || i == row-1 || j == 0 || j == col-1) {
                    uf.union(dummyNode, i*col+j);
                    continue;
                }
                for (int k = 0; k < dirs.length; k++) {
                    int nextX = i + dirs[k][0];
                    int nextY = j + dirs[k][1];
                    if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < col && board[nextX][nextY] == 'O') 
                        uf.union(i*col+j, nextX*col + nextY);
                }
            }
        }
        
        // check every 'O' if has the same parent with the dummynode
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'X' || uf.find(i*col+j) == uf.find(dummyNode)) continue;
                board[i][j] = 'X';
            }
        }
    }
    
    class UnionFind {
        int[] parent;
        public UnionFind(char[][] board) {
            int row = board.length, col = board[0].length;
            parent = new int[row * col + 1];
            
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == 'O') {
                        int idx = i*col + j;
                        parent[idx] = idx;
                    }    
                }
            }
            parent[row * col] = row*col;
        }
        
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY)
                parent[rootX] = rootY;
        }
        
        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
}
