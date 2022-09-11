class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        long mod = (long)(1e9+7);
        int[][] engineer = new int[n][2];
        for (int i = 0; i < n; i++) {
            engineer[i][0] = speed[i];
            engineer[i][1] = efficiency[i];
        }
        Arrays.sort(engineer, (a, b) -> (b[1]== a[1] ? a[0]-b[0] : b[1] - a[1]));
        
        // pq
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long speed_sum = 0;
        long rets = 0;
        for (int i = 0; i < n; i++) {
            int[] cur = engineer[i];
            speed_sum += cur[0];
            
            
            while (pq.size() > k-1) {
                speed_sum -= pq.poll();
            }
            //System.out.println(i + " " + cur[1] + " " + speed_sum  + " " + (speed_sum*cur[1]));
            //rets = Math.max(rets, (long)((speed_sum%mod*cur[1]%mod)%mod));
            rets = Math.max(rets, speed_sum*cur[1]);
            pq.offer(cur[0]);
        }
        return (int)(rets%mod);
    }
}
