class Solution {
    class Pair {
        int x; 
        int y;
        int state;
        
        public Pair(int x, int y, int state) {
            this.x = x;
            this.y = y;
            this.state = state;
        }
    }
    
    public int shortestPathAllKeys(String[] grid) {
        int row = grid.length, col = grid[0].length();
        int finalState = 0, count = 0;
        Queue<Pair> queue = new LinkedList<>();
        List<List<Set<Integer>>> visited = new ArrayList<>(); // consider to store boolean val
        //Set<Integer>[][] visited = new HashSet<>[row][col];
        for (int i = 0; i < row; i++) {
            visited.add(new ArrayList<Set<Integer>>());
            for (int j = 0; j < col; j++) {
                visited.get(i).add(new HashSet<>());
            }
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char cur = grid[i].charAt(j);
                if (cur == '@') {
                    queue.offer(new Pair(i, j, 0));
                    visited.get(i).get(j).add(0);
                } else if (cur >= 'a' && cur <= 'f') {
                    count++;
                }
            }
        }
        for (int i = 0;i < count; i++) {
            finalState |= 1<<i;
        }
        
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair p = queue.poll();
                
                // four direction
                int[] dirs = {0, -1, 0, 1, 0};
                for (int k = 0; k < 4; k++) {
                    int cx = p.x + dirs[k];
                    int cy = p.y + dirs[k+1];
                    if (cx < 0 || cx >= row || cy < 0 || cy >= col) continue;
                    char ch = grid[cx].charAt(cy);
                    if (ch == '#') continue;
                    int nextState = p.state;
                    if (ch >= 'A' && ch <= 'F') {
                        if ((nextState>>(ch-'A')&1) == 0) continue;
                    }
                    if (ch >= 'a' && ch <= 'f') 
                        nextState |= 1<<(ch-'a');
                    
                    if (visited.get(cx).get(cy).contains(nextState)) continue;
                    //System.out.println("sub pos -> " + ch + " : and current state -> " + nextState);
                    if (nextState == finalState) return step;
                    queue.add(new Pair(cx, cy, nextState));
                    visited.get(cx).get(cy).add(nextState);
                    
                }
            }
        }
        return -1;
    }
}
