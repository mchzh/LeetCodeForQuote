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
        //for (int[] s : sweep) System.out.println(s[0] + " " + s[1] + " " + s[2] + " " + s[3]);

        int[] range = new int[2];
        Arrays.fill(range, Integer.MIN_VALUE);
        List<int[]> intervals = new ArrayList<>();
        // scan sweep line
        int count = 0;
        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < 2*n; i++) { //  case : gap between start and end line
            // int[] s = sweep[i];
            // if (s[1] == 1) {
            //     count++;
            // } else {
            //     count--;
            // }
            // if (count < 0) return false;
            int[] s = sweep[i];
            //System.out.println(i + " " + s[0] + " " + prev + " " + s[1]);
            if (s[1] == 1) {
                if (prev != Integer.MIN_VALUE && prev != s[0]) return false;
            } else {
                prev = s[0];
            }

            int j = i;
            while (j < 2*n && sweep[j][1] == s[1] && sweep[j][0] == s[0]) {
                int[] cur = sweep[j];
                int start = cur[2];
                int end = cur[3];
                if (s[1] == 1) {
                    if (i == 0) {
                        // first start line
                        if (range[0] == Integer.MIN_VALUE) {
                            range[0] = cur[2];
                            range[1] = cur[3];
                        } else {
                            if (cur[2] != range[1]) return false;
                            range[1] = cur[3];
                        }
                    } else {
                        //Sy
                        if (start < range[0] || start > range[1] || end < range[0] || end > range[1]) return false;
                        if (intervals.size() == 0) return false;
                        int[] comp = intervals.get(0);
                        if (start != comp[0]) return false;
                        if (end > comp[1]) return false;
                        // end > fill end or < fill end
                        if (end == comp[1]) intervals.remove(0);
                        else if (end < comp[1]) {
                            intervals.set(0, new int[] {end, comp[1]});
                        }
                    }
                } else {
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
                
                j++;
            }
            //System.out.println("this loop end -> " + i + " " + j);
            i = j-1;
        }

        return true;
    }
}
