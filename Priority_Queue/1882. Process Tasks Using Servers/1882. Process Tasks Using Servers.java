class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int[]> freeBq = new PriorityQueue<>( (a, b) -> (a[0] == b[0] ? a[1]-b[1] : a[0] - b[0]) );
        PriorityQueue<int[]> busyBq = new PriorityQueue<>( (a, b) -> (a[0] == b[0] ? (a[1]==b[1] ? a[2]-b[2] : a[1]-b[1]) : a[0] - b[0]));
        
        for (int i = 0; i < servers.length; i++) {
            freeBq.offer(new int[] {servers[i], i}); // weight and idx
        }
        
        Queue<Integer> jobs = new LinkedList<>();
        int[] rets = new int[tasks.length];
        for (int i = 0; i < tasks.length; i++) {
            jobs.offer(i);
            // move the free of busy queue into free
            while (!busyBq.isEmpty() && busyBq.peek()[0] <= i) {
                int[] cur = busyBq.poll();
                freeBq.offer(new int[] {cur[1], cur[2]});
            }
            while (!jobs.isEmpty() && !freeBq.isEmpty()) {
                int[] assign = freeBq.poll();
                int jobid = jobs.poll();
                rets[jobid] = assign[1];
                int during = tasks[jobid];
                busyBq.offer(new int[] {i+during, assign[0], assign[1]}); // start time from i
            }
        }
        
        while (!jobs.isEmpty()) { // no new job add and process the existed job without finishing
            int[] assign = busyBq.poll();
            int jobid = jobs.poll();
            rets[jobid] = assign[2];
            int during = tasks[jobid];
            busyBq.offer(new int[] {assign[0]+during, assign[1], assign[2]}); // start time from time work of current pq element
        }
        return rets;
    }
}
// two pq
// [timetoWork, weight, idx]

// 8:00  1
// 9:00  2
// ---
// 10:00 when this time need to check free server 1 and 2
    
// freeBQ {weight, idx}
// busyBQ {timetoWork, weight, idx}
