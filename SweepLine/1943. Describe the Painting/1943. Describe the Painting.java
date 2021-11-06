class Solution {
    // sweep line + sort : first add then substract
    public List<List<Long>> splitPainting(int[][] segments) {
        int n = segments.length;
        
        long[][] sweep = new long[2*n][2];
        for (int i = 0; i < n; i++) {
            sweep[2*i][0] = segments[i][0];
            sweep[2*i][1] = segments[i][2];
            //sweep[2*i][2] = i;
            sweep[2*i+1][0] = segments[i][1];
            sweep[2*i+1][1] = -segments[i][2];
            //sweep[2*i+1][2] = i;
        }
        Arrays.sort(sweep, (a, b) -> (a[0] == b[0] ? (int)(a[1] - b[1]) : (int)(a[0] - b[0])));
        //for (long[] s : sweep) System.out.println(s[0] + " " + s[1]); 
        
        List<List<Long>> rets = new ArrayList<>();
        long count = 0;
        long prevpos = -1;
        for (int i = 0; i < 2*n; i++) {
            long[] cur = sweep[i];
            if (cur[1] > 0) {
                if (count > 0 && prevpos != cur[0]) {
                    List<Long>  list = new ArrayList<>();
                    list.add(prevpos);
                    list.add(cur[0]);
                    list.add(count);
                    rets.add(list);  
                }
                count += cur[1];
                prevpos = cur[0];
            } else {
                if (count > 0 && prevpos != cur[0]) {
                    List<Long>  list = new ArrayList<>();
                    list.add(prevpos);
                    list.add(cur[0]);
                    list.add(count);
                    rets.add(list);  
                }
                count += cur[1];
                prevpos = cur[0];
            }
        }
        return rets;
    }
}
