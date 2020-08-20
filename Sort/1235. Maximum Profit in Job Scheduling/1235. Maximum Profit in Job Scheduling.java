class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        // sorted data structure for endtime
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a, b) -> (a[0] -b[0]) );
        int N = startTime.length;
        int[] sortedEndTime = new int[N+1];
        for (int i = 0; i < N; i++) {
            pq.offer(new int[] {endTime[i], startTime[i], profit[i]});
            sortedEndTime[i+1] = endTime[i];
        }
        Arrays.sort(sortedEndTime);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        // for the current earliest endtime to handle
        int curVal = 0;
        while ( !pq.isEmpty() ) {
            int[] info = pq.poll();
            int endT = info[0];
            int startT = info[1];
            int val = info[2];
            
            int beforeIdx = Arrays.binarySearch(sortedEndTime, startT);
            int prevEnd = beforeIdx < 0 ? sortedEndTime[(-1)*beforeIdx-2] : sortedEndTime[beforeIdx];
            curVal = Math.max(curVal, map.get(prevEnd) + val);
            map.put(endT, curVal);
        }
        return curVal;
    }
}

// -----------
//     ----------
//       -------------
//    -----------e`
// ------e 
//           s--------t
// dp[t] : max (dp[nearestEndTimeForCurrentMeeting], dp[lastEndTimeBeforeStartTime] + val[t]); // not select and select
