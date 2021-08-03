class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) return intervals;
        
        // sweep line
        int n = intervals.length;
        int[][] sweep = new int[2*n][2];
        for (int i = 0; i < n; i++) {
            sweep[2*i][0] = intervals[i][0];
            sweep[2*i][1] = 1;
            sweep[2*i+1][0] = intervals[i][1];
            sweep[2*i+1][1] = -1;
        }
        Arrays.sort(sweep, (a, b) -> ( a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
        
        int count = 0;
        int range = -1;
        List<int[]> list = new ArrayList<>();
        for (int[] s : sweep) {
            count += s[1];
            if (s[1] == 1&& count == 1) range = s[0];
            if (s[1] == -1&& count == 0) list.add(new int[] {range, s[0]});  
        }
        return list.toArray(new int[list.size()][]);
    }
}
