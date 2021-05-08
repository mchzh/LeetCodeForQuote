class Solution {
    // BFS
    public int slidingPuzzle(int[][] board) {
        // target is "123450"
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        String init = "";
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                init += (char)('0' + board[i][j]);
            }
        }
        q.offer(init);
        visited.add(init);
        
        if (init.equals("123450")) return 0;
        int step = -1;
        int[][] dirs = {{-1, 0},{1, 0},{0,1},{0,-1}};
        while (!q.isEmpty()) {
            int size = q.size();
            step++;
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals("123450")) return step;
                
                int idx = -1;
                for (int j = 0; j < cur.length(); j++) {
                    if (cur.charAt(j) == '0') idx = j;
                }
                
                int x = idx/3; // row
                int y = idx%3; // col
                for (int k = 0; k < 4; k++) {
                    int cx = x + dirs[k][0];
                    int cy = y + dirs[k][1];
                    if (cx < 0 || cx >= 2) continue;
                    if (cy < 0 || cy >= 3) continue;
                    int newidx = cx*3+cy;
                    // swap the idx and newidx of cur
                    char[] chrs = cur.toCharArray();
                    char temp = chrs[idx];
                    chrs[idx] = chrs[newidx];
                    chrs[newidx] = temp;
                    String next = String.valueOf(chrs);
                    
                    if (visited.contains(next)) continue;
                    q.offer(next);
                    visited.add(next);
                }
            }
        }
        return -1;
    }
}

// 0 1
// 0 2
// 0 3
// 1 4
// 1 5
// 1 0
