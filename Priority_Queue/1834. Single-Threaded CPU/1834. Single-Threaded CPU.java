class Solution {
    // sort + pq
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] ts = new int[n][3];
        for (int i = 0; i < n; i++) {
            ts[i][0] = tasks[i][0];// satar tiem
            ts[i][1] = i;
            ts[i][2] = tasks[i][1];
        }
        Arrays.sort(ts, (a, b) -> (a[0] - b[0]));
        // for (int[] s : ts) {
        //     System.out.println(s[0] + " : " + s[1] + " : " + s[2]);
        // }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] == b[0] ? (a[1]-b[1]) : (a[0]-b[0])));
        long curTime = 0;
        int[] rets = new int[n];
        int idx = 0;
        for (int[] t : ts) {
            while (!pq.isEmpty() && curTime < t[0]) {
                int[] cur = pq.poll();
                curTime += (long)cur[0];
                rets[idx++] = cur[1];
                //System.out.println(curTime +" : " + cur[0] + " : " + cur[1] + " : " + rets[0]);
            }
            if (curTime < t[0]) {
                curTime = Math.max(curTime, (long)t[0]);
            }
            pq.offer(new int[] {t[2], t[1]});
        }
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            rets[idx++] = cur[1];
        }
        return rets;
    }
}

// cur time >= task : push into pq
// cur time < task : make cur time into the current available task start time
