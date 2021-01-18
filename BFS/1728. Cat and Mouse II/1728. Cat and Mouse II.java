class Solution {
    int[][][][][] memo = new int[9][9][9][9][3]; // m: x y; c: x y; turn: 1&2
    int[] food = new int[2];
    int[] mouse = new int[2];
    int[] cat = new int[2];
    String[] grid;
    int catJump;
    int mouseJump;
    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        // get final status
        this.grid = grid;
        this.catJump = catJump;
        this.mouseJump = mouseJump;
        int m = grid.length, n = grid[0].length();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == 'F') {
                    food[0] = i;
                    food[1] = j;
                } else if (grid[i].charAt(j) == 'M') {
                    mouse[0] = i;
                    mouse[1] = j;
                } else if (grid[i].charAt(j) == 'C') {
                    cat[0] = i;
                    cat[1] = j;
                }
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        // get win status
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '#') continue;
                if (i == food[0] && j == food[1]) continue;
                for (int t =1; t <= 2; t++) {
                    memo[i][j][food[0]][food[1]][t] = 2;
                    memo[food[0]][food[1]][i][j][t] = 1;
                    q.offer(new int[] {i, j, food[0], food[1], t});
                    q.offer(new int[] {food[0], food[1], i, j, t});
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int t =1; t <= 2; t++) {
                    if (grid[i].charAt(j) == '#') continue;
                    memo[i][j][i][j][t] = 2;
                    q.offer(new int[] {i, j, i, j, t});
                }
            }
        }
        
        int step = 0;
        while (!q.isEmpty()) {
            step++;
            if (step > 2000) return false;
            int size = q.size();
        
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int mx = cur[0];
                int my = cur[1];
                int cx = cur[2];
                int cy = cur[3];
                int t = cur[4];
                int status = memo[mx][my][cx][cy][t];

                for (int[] next : getAllAdjacents(mx, my, cx, cy, t)) {
                    int mx2 = next[0];
                    int my2 = next[1];
                    int cx2 = next[2];
                    int cy2 = next[3];
                    int t2 = next[4];

                    if (memo[mx2][my2][cx2][cy2][t2] != 0) continue;
                    
                    if (t2 == status) {
                        memo[mx2][my2][cx2][cy2][t2] = status;
                        q.offer(new int[] {mx2, my2, cx2, cy2, t2});
                    } else if (AllAdjacentWin(mx2, my2, cx2, cy2, t2)) {
                        memo[mx2][my2][cx2][cy2][t2] = (t2 == 1) ? 2 : 1;
                        q.offer(new int[] {mx2, my2, cx2, cy2, t2});
                    }
                }
            }
            
        }
        
        // mouse and cat initinal pos
        //System.out.println(memo[mouse[0]][mouse[1]][cat[0]][cat[1]][1]);
        return memo[mouse[0]][mouse[1]][cat[0]][cat[1]][1] == 1;
    }
    private List<int[]> getAllAdjacents(int mx, int my, int cx, int cy, int t) {
        List<int[]> list = new ArrayList<>();
        int m = grid.length, n = grid[0].length();
        int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        if (t == 1) {
            for (int k = 0; k < 4; k++) {
                for (int i = 0; i <= catJump; i++) {
                    int cx2 = cx + dir[k][0]*i;
                    int cy2 = cy + dir[k][1]*i;
                    if (cx2 < 0 || cx2 >= m || cy2 < 0 || cy2 >= n) continue;
                    if (grid[cx2].charAt(cy2) == '#') break;
                    list.add(new int[] {mx, my, cx2, cy2, 2});
                }
            }
        } else if (t == 2){
            for (int k = 0; k < 4; k++) {
                for (int i = 0; i <= mouseJump; i++) {
                    int mx2 = mx + dir[k][0]*i;
                    int my2 = my + dir[k][1]*i;
                    if (mx2 < 0 || mx2 >= m || my2 < 0 || my2 >= n) continue;
                    if (grid[mx2].charAt(my2) == '#') break;
                    list.add(new int[] {mx2, my2, cx, cy, 1});
                }
            }
        }
        
        return list;
    }
    private boolean AllAdjacentWin(int mx, int my, int cx, int cy, int t) {
        int m = grid.length, n = grid[0].length();
        int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        if (t == 1) {
            for (int k = 0; k < 4; k++) {
                for (int i = 0; i <= mouseJump; i++) {
                    int mx2 = mx + dir[k][0]*i;
                    int my2 = my + dir[k][1]*i;
                    if (mx2 < 0 || mx2 >= m || my2 < 0 || my2 >= n) break;
                    if (grid[mx2].charAt(my2) == '#') break;
                    
                    if (memo[mx2][my2][cx][cy][2] != 2) return false;
                }
            }
        } else if (t == 2){
            for (int k = 0; k < 4; k++) {
                for (int i = 0; i <= catJump; i++) {
                    int cx2 = cx + dir[k][0]*i;
                    int cy2 = cy + dir[k][1]*i;
                    if (cx2 < 0 || cx2 >= m || cy2 < 0 || cy2 >= n) break;
                    if (grid[cx2].charAt(cy2) == '#') break;
                    if (memo[mx][my][cx2][cy2][1] != 1) return false;
                }
            }
        }
        
        return true;
    }
}

// minmax:
// DFS(state, A) ->
//     DFS(nextst1, B),DFS(nextst2, B),DFS(nextst3, B),......DFS(nextstn, B),

// start with all the known final state
// => orginal state (m0, c0, 1) = ? 1 mouse wins : 2 cat wins : 0 draw

// (m, c, t) => (m2, c2, t2), (m3, c3, t3), (m4, c4, t4),...
    
// wins condition:
// 1. (m, food, t) -> cat wins
// 2. (food, c, t) -> mouse wins
// 3. (p, p, t) -> cat wins

// (m, c, t) <=> (m2, c2, t2)
// 1. when (m2, c2, t2) must win?
//     if (m, c, t) : mouse turn, cat wins =>  (m2, c2, t2) must win (cat turn)
//     if (m, c, t) : cat turn, mouse wins =>  (m2, c2, t2) must win (mouse turn)
    
// 2. when (m2, c2, t2) must lose?
//     if all (mm, cc, tt) : cat turn, cat wins =>  (m2, c2, t2) must lose (mouse turn)
//     if all (mm, cc, tt) : mouse turn, mouse wins =>  (m2, c2, t2) must lose (cat turn)
