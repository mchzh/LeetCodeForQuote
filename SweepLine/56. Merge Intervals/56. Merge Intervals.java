class Solution {
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
//         if (intervals == null || intervals.length == 0 || intervals[0].length == 0) return intervals;
//         Arrays.sort(intervals, (a, b) -> (a[0]-b[0]));
//         List<int[]> list = new ArrayList<>();
//         int start = intervals[0][0], end = intervals[0][1];
//         for (int i = 1; i < intervals.length; i++) {
//             if (intervals[i][0] <= end) {
//                 start = Math.min(start, intervals[i][0]);
//                 end = Math.max(end, intervals[i][1]);
//             } else {
//                 list.add(new int[] {start, end});
//                 start = intervals[i][0];
//                 end = intervals[i][1];
//             }
//         }
//         list.add(new int[] {start, end});
        
// //         int[][] rets = new int[list.size()][2];
// //         for (int i = 0;i < list.size(); i++) {
// //             rets[i] = list.get(i);
// //         }
// //         return rets;
//         return list.toArray(new int[list.size()][]);
    }
}

// s--------e
//     s'------e'
//     s2-----e2
