class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]) );
        
        int rets = 0;
        int[] curStand = Arrays.copyOf(intervals[0], 2);
        for (int i = 1; i < intervals.length; i++) {
            // if  overlap
            if (intervals[i][0] < curStand[1]) {
                rets += 1;   
            } else {
                curStand[0] = intervals[i][0];
                curStand[1] = intervals[i][1];
            }
            if (intervals[i][1] < curStand[1]) {
                curStand[0] = intervals[i][0];
                curStand[1] = intervals[i][1];
            }
        }
        return rets;
    }
}
