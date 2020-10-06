class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int N = arrival.length;
        PriorityQueue<int[]> busy = new PriorityQueue<>((a,b) -> (a[0]-b[0]));
        TreeSet<Integer> free = new TreeSet<>();
        int[] count = new int[k];
        int maxVal = 0;
        List<Integer> rets = new ArrayList<>();
        
        for (int i = 0; i < k; i++) {
            free.add(i);
        }
        
        for (int i = 0; i < N; i++) {
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                int[] cur = busy.peek();
                busy.poll();
                free.add(cur[1]);
            }
            
            // find freed server
            if (free.isEmpty()) continue;
            int serverId;
            if (free.ceiling(i%k) != null) {
                serverId = free.ceiling(i%k);
            } else {
                // first server
                serverId= free.first();
            }
            free.remove(serverId);
            busy.offer(new int[] {arrival[i] + load[i], serverId});
            count[serverId]++;
            maxVal = Math.max(maxVal, count[serverId]);
        }
        
        for (int i = 0; i < k; i++) {
            if (count[i] == maxVal) rets.add(i);
        }
        return rets;
    }
}

// free -> sorted (TreeMap) 
// busy -> heap (time : id)
// emulate the processing

/*class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] servers = new int[k];
        int[] reqs = new int[k];
        int max = 0;
        
        TreeSet<Integer> available = new TreeSet<Integer>();
        for (int i=0; i<k; i++) {
            available.add(i);
        }
        PriorityQueue<int[]> busy = new PriorityQueue<int[]>((a, b) -> (a[0]-b[0]));
        
        for (int i=0; i<arrival.length; i++) {
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                int[] server = busy.poll();
                available.add(server[1]);
            }
            if (available.isEmpty()) {
                continue;
            }
            Integer usable = available.ceiling(i%k);
            if (usable == null) {
                usable = available.first();
            }
            busy.offer(new int[]{arrival[i]+load[i], usable});
            available.remove(usable);
            reqs[usable] ++;
            if (max < reqs[usable]) {
                max = reqs[usable];
            }
        }
        
        List<Integer> busiest = new ArrayList<Integer>();
        for (int i=0; i<k; i++) {
            if (max == reqs[i]) busiest.add(i);
        }
        return busiest;
    }
}*/
