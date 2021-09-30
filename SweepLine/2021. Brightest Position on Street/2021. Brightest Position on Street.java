class Solution {
    // sweep line
    public int brightestPosition(int[][] lights) {
        int n = lights.length;
        int[][] interval = new int[2*n][2];
        for (int i = 0; i < n; i++) {
            interval[2*i][0] = lights[i][0]-lights[i][1];
            interval[2*i][1] = 1;
            interval[2*i+1][0] = lights[i][0]+lights[i][1];
            interval[2*i+1][1] = -1;
        }
        // sort the interval
        Arrays.sort(interval, (a, b) -> (a[0] == b[0] ? b[1]-a[1] : a[0]-b[0]));
        // sweep line
        int count = 0;
        int lightdegree = 0;
        int rets = Integer.MIN_VALUE;
        for (int i = 0; i < 2*n; i++) {
            int[] cur = interval[i];
            count += cur[1];  // intersection number
            
            if (count > lightdegree) {
                rets = cur[0];
                lightdegree = count;
            }
        }
        return rets;
    }
}
