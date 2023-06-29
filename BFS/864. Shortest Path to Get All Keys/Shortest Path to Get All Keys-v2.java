class Solution {
    // BFS + key status + with statue
    // define a class to store x, y, and current state
    // every point can pass multiple times
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length();
        //System.out.println(m + " " + n);
        int countKey = 0;
        Map<String, Set<Integer>> visited = new HashMap<>();
    
        Queue<int[]> q = new LinkedList<>();
        // get the start x and y; key numbers
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    q.offer(new int[] {i, j, 0});
                    visited.computeIfAbsent(String.valueOf(i) + "*" + String.valueOf(j), k -> new HashSet<>()).add(0);
                } else if (c >= 'a' && c <= 'z') {
                    countKey++;
                }
            }
        }
        int stateStatus = (1<<countKey)-1;

        // BFS steps
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int level = 0;
        while (!q.isEmpty()) {
            level++;
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                int state = cur[2];
                if (state == stateStatus) return level-1;
                //System.out.println(x + " " + y );

                for (int k = 0; k < 4; k++) {
                    int cx = x + dirs[k][0];
                    int cy = y + dirs[k][1];
                    
                    if (cx < 0 || cx >= m) continue;
                    if (cy < 0 || cy >= n) continue;
                    //System.out.println(cx + " " + cy);
                    // visited
                    char ctemp = grid[cx].charAt(cy);
                    if (ctemp == '#') continue;
                    int newState = state;
                    if (ctemp >= 'a' && ctemp <= 'z') {
                        newState |= (1<<(ctemp-'a'));
                    }
                    String nodeKey = String.valueOf(cx) + "*" + String.valueOf(cy);
                    if (visited.containsKey(nodeKey) && visited.get(nodeKey).contains(newState)) continue;
                    
                    // key with lock
                    if (ctemp >= 'A' && ctemp <= 'Z') {
                        if ( ((state>>(ctemp-'A'))&1) == 0) continue;
                    }
                    // bfs can tranverse this point
                    q.offer(new int[] {cx, cy, newState});
                    visited.computeIfAbsent(nodeKey, z -> new HashSet<>()).add(newState);
                }
            }
            
        } // end-while

        return -1;
    }
}
