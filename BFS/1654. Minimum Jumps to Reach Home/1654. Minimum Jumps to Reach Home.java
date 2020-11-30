class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        if (x == 0) return 0;
        int[][] visited = new int[8001][2];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});
        int maxf = 0;
        for (int f : forbidden) {
            visited[f][0] = -1;
            visited[f][1] = -1;
            maxf = Math.max(maxf, f);
        }
        int limit = Math.max(x, maxf)+b;
        visited[0][0] = 1;
        
        
        int level = 0;
        while (!q.isEmpty()) {
            level++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int curPos = cur[0];
                int dir = cur[1]; // 0: right, 1: left
                // go right
                if (curPos <= limit && visited[curPos+a][0] == 0) {
                    if (curPos+a == x) return level;
                    visited[curPos+a][0] = 1;
                    q.offer(new int[] {curPos+a, 0});
                }
                if (dir == 0) {
                    if (curPos-b >= 0 && visited[curPos-b][1] == 0) {
                        if (curPos-b == x) return level;
                        visited[curPos-b][1] = 1;
                        q.offer(new int[] {curPos-b, 1});
                    }
                }
            } 
            
        }
        return -1;
    }
}
// limit = max(x, maxforbidden) + b

// if (cur < limit) go right;
// if (lasttiem is right || cur >= limit) go left;
