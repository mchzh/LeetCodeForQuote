class Solution {
    int[][][] memo = new int[50][50][3];
    public int catMouseGame(int[][] graph) {
        int n = graph.length;
        // set initial state
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int t = 1; t <= 2; t++) {
                memo[0][i][t] = 1;
                q.offer(new int[] {0, i, t});
                
                if (i != 0) {
                    memo[i][i][t] = 2;
                    q.offer(new int[] {i, i, t});
                }
            }
        }
        
        while (!q.isEmpty()) {
            
            int[] cur = q.poll();
            int m = cur[0];
            int c = cur[1];
            int t = cur[2];
            int status = memo[m][c][t];
                
            for (int[] next : findAllAdjacents(graph, m, c, t)) {
                int m2 = next[0];
                int c2 = next[1];
                int t2 = next[2];
                    
                if (memo[m2][c2][t2] != 0) continue;  // has been terminated
                    
                if (t2 == status) {
                    memo[m2][c2][t2] = status;
                    q.offer(new int[] {m2, c2, t2});
                } else if (allChildrenWin(graph, m2, c2, t2)) {
                    memo[m2][c2][t2] = (t2 == 1) ? 2 : 1;
                    q.offer(new int[] {m2, c2, t2});
                }
            }
        }
        
        return memo[1][2][1];
    }
    private List<int[]> findAllAdjacents(int[][] graph, int m, int c, int t) {
        List<int[]> list = new ArrayList<>();
        if (t == 1) {
            for (int cx : graph[c]) {
                if (cx != 0) list.add(new int[] {m, cx, 2});
            }
        } else if (t == 2) {
            for (int mx : graph[m]) {
                list.add(new int[] {mx, c, 1});
            }
        }
        return list;
    }
    private boolean allChildrenWin(int[][] graph, int m, int c, int t) {
        if (t == 1) {
            for (int mx : graph[m]) {
                if (memo[mx][c][2] != 2) return false;
            }
        } else if (t == 2) {
            for (int cx : graph[c]) {
                if (cx != 0 && memo[m][cx][1] != 1) return false;
            }
        }
        return true;
    }
}

// find all the known state => original state: (m0, c0, 1)

// wins condition:
// 1. (p, p , t) => cat wins
// 2. (0, c, t) => mouse wins
