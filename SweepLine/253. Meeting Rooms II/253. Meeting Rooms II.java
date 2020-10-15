class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) return 0;
        // sweep line
        int N = intervals.length;
        int[] start = new int[N];
        int[] end = new int[N];
        
        for (int i = 0; i < N; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        
        // scan from start
        int i = 0, j = 0;
        int max = 0, count = 0;
        while (i < N) {
            if (start[i] < end[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
