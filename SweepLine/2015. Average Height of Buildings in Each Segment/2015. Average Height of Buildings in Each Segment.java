class Solution {
    // sweep line
    public int[][] averageHeightOfBuildings(int[][] buildings) {
        int n = buildings.length;
        int[][] sweep = new int[2*n][3];
        for (int i  = 0; i < n; i++) {
            int[] b = buildings[i];
            sweep[2*i][0] = b[0];
            sweep[2*i][1] = 1;
            sweep[2*i][2] = b[2];
            sweep[2*i+1][0] = b[1];
            sweep[2*i+1][1] = -1;
            sweep[2*i+1][2] = b[2];
        }
        
        // array sort
        Arrays.sort(sweep, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        
        int count = 0;
        int prevs = -1;
        int sum = 0;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < 2*n; i++) {
            int[] s = sweep[i];
            if (prevs != -1 && s[0] > prevs && count > 0) {
                if (list.size() != 0) {
                    int[] last = list.get(list.size()-1);
                    if (last[2] == sum/count && prevs <= last[1]) {
                        last[0] = Math.min(last[0], prevs);
                        last[1] = Math.max(last[1], s[0]);
                        list.set(list.size()-1, last);
                    } else list.add(new int[] {prevs, s[0], sum/count});
                } else list.add(new int[] {prevs, s[0], sum/count});
            }
            sum += s[1]*s[2];
            count += s[1];
            prevs = s[0];
        }
        
        // merge the same heights range
//         int size = list.size();
//         List<int[]> list1 = new ArrayList<>();
//         for (int i = 0; i < size; i++) {
            
//         }
        // convert to array;
        int size = list.size();
        int[][] rets = new int[size][3];
        int idx = 0;
        for (int i = 0; i < size; i++) {
            int[] cur = list.get(i);
            rets[idx][0] = cur[0];
            rets[idx][1] = cur[1];
            rets[idx][2] = cur[2];
            idx++;
        }
        return rets;
    }
}
