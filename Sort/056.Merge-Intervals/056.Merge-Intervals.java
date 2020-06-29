
class Solution {
    // sweep line
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return intervals;
        // generate sweep line
        int[][] sweep = new int[intervals.length*2][2];
        for (int i = 0; i < intervals.length; i++) {
            sweep[2*i][0] = intervals[i][0];
            sweep[2*i][1] = 1;
            sweep[2*i+1][0] = intervals[i][1];
            sweep[2*i+1][1] = -1;
        }
        Arrays.sort(sweep, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1]-a[1];
            } else {
                return a[0]-b[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        int count = 0;
        int[] temp = new int[2];
        for (int[] s : sweep) {
            if (s[1] == 1) {
                count++;
                if (count == 1) {
                    temp[0] = s[0];
                }
            } else {
                count--;
                if (count == 0) {
                    temp[1] = s[0];
                    //System.out.println("start -> " + temp[0] + " : end -> " + temp[1]);
                    list.add(new int[] {temp[0], temp[1]});
                }
            }
        }
        return list.toArray(new int[list.size()][]);
        
        /*Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1]-b[1];
            } else {
                return a[0]-b[0];
            }
        });
        int[] interval = new int[2];
        interval[0] = intervals[0][0];
        interval[1] = intervals[0][1];
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (interval[1] < intervals[i][0]) { // non-overlap
                list.add(new int[]{interval[0], interval[1]});
                interval[0] = intervals[i][0];
                interval[1] = intervals[i][1];
            } else {
                interval[0] = Math.min(interval[0], intervals[i][0]);
                interval[1] = Math.max(interval[1], intervals[i][1]); //intervals[0][1];
            }
        }
        list.add(new int[]{interval[0], interval[1]});
        return list.toArray(new int[list.size()][]);*/
        /*list.add(new int[]{interval[0], interval[1]});
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            int[] temp = list.get(i);
            res[i][0] = temp[0];
            res[i][1] = temp[1];
        }
        return res;*/
    }
}
/*class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return intervals;
        List<int[]> intervalList = new ArrayList<>();
        Arrays.sort(intervals, (a,b) ->(a[0]-b[0]));
        
        
        int[] newInterval = intervals[0];
        intervalList.add(newInterval);
        
        for (int[] interval:intervals) {
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                newInterval = interval;
                intervalList.add(interval);
            }
        }
        
        return intervalList.toArray(new int[intervalList.size()][]);
        
    }
}
*/
