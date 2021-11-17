class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int n = rectangles.length;
        int[][] sweep = new int[2*n][4];
        for (int i = 0; i <n; i++) {
            int[] r = rectangles[i];
            sweep[2*i][0] = r[0];
            sweep[2*i][1] = 1;
            sweep[2*i][2] = r[1];
            sweep[2*i][3] = r[3];
            sweep[2*i+1][0] = r[2];
            sweep[2*i+1][1] = -1;
            sweep[2*i+1][2] = r[1];
            sweep[2*i+1][3] = r[3];
        }
        Arrays.sort(sweep, (a, b) -> (a[0] == b[0] ? (a[1] == b[1] ? a[3]-b[3] : a[1] - b[1]) : a[0]-b[0]) );
        
        List<int[]> intervals = new ArrayList<>();
        // scan sweep line
        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < 2*n; i++) { //  case : gap between start and end line
            int[] s = sweep[i];
            if (i == 0) { // first start rectangle line -> leftmost vertical line
                int t = i;
                int curend = Integer.MIN_VALUE;
                while (t < 2*n && sweep[t][1] == 1 && sweep[t][0] == s[0]) {
                    int[] cur = sweep[t];
                    if (curend != Integer.MIN_VALUE && cur[2] != curend) return false;
                    curend = cur[3];
                    t++;
                }
                i = t-1;
                continue;
            }

            int start = s[2];
            int end = s[3];
            if (s[1] == 1) {
                if (prev != Integer.MIN_VALUE && prev != s[0]) return false;
                if (intervals.size() == 0) return false;
                int[] comp = intervals.get(0);
                if (start != comp[0]) return false;
                if (end > comp[1]) return false;
                if (end == comp[1]) intervals.remove(0);
                else if (end < comp[1]) {
                    intervals.set(0, new int[] {end, comp[1]});
                }
            } else {
                prev = s[0];
                // end line to add empty range to intervals
                if (intervals.size() == 0) {
                    intervals.add(new int[] {start, end});
                } else {
                    int[] comp = intervals.get(intervals.size()-1);
                    if (start == comp[1]) {
                        intervals.set(intervals.size()-1, new int[] {comp[0], end});
                    } else {
                        intervals.add(new int[] {start, end});
                    }
                }
            }
        }

        return true;
    }
}
