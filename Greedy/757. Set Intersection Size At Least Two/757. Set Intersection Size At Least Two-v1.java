class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[1] == b[1] ? b[0]-a[0] : a[1]-b[1]));
        int a = intervals[0][1]-1, b = intervals[0][1];
        
        int rets = 2;
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            if (cur[0] <= a) { // selected two points inside this range
                continue;
            } else if (cur[0] <= b) { // only b inside this range
                a = b;
                b = cur[1];
                rets += 1;
            } else { // both not inside this range
                a = cur[1]-1;
                b = cur[1];
                rets += 2;
            }
        }
        return rets;
    }
}
// break ballon
// sort with the end points
