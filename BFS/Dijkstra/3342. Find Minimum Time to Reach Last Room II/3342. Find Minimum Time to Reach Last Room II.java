class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length, n = moveTime[0].length;
        int[][] curMin = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            int[] cur = curMin[i];
            Arrays.fill(cur, Integer.MAX_VALUE);
        }
        curMin[0][0] = 0;
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2]-b[2]));
        pq.offer(new int[]{0,0,0,1});
        while (!pq.isEmpty()) {
            int size = pq.size();
            for (int i = 0; i < size; i++) {
                int[] cur = pq.poll();
                int x = cur[0];
                int y = cur[1];
                int currd = cur[2];
                int alteradd = cur[3];
                if (x == m-1 && y == n-1) return currd;
                if (visited[x][y]) continue;
                visited[x][y] = true;

                // next
                for (int k = 0; k < 4; k++) {
                    int nextx = x + dirs[k][0];
                    int nexty = y + dirs[k][1];
                    if (nextx < 0 || nextx >= m) continue;
                    if (nexty < 0 || nexty >= n) continue;
                    if (visited[nextx][nexty]) continue;
                    int d = Math.max(currd, moveTime[nextx][nexty]) + alteradd;
                    if (d < curMin[nextx][nexty]) {
                        curMin[nextx][nexty] = d;
                        pq.offer(new int[] {nextx, nexty, d, (3-alteradd)%3});
                    } // else discard
                }
            }
        }
        return -1;
    }
}
