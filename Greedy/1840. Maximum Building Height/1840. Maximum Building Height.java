class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        int m = restrictions.length+1;
        int[] h = new int[m];
        int[] pos = new int[m];
        int[] lim = new int[m];
        Arrays.sort(restrictions, (a, b) -> (a[0] - b[0]));

        h[0] = 0;
        pos[0] = 1;
        lim[0] = 0;
        // first postion is 0
        for (int i = 1; i < m; i++) {
            pos[i] = restrictions[i-1][0];
            lim[i] = restrictions[i-1][1];
            h[i] = Math.min(lim[i], h[i-1] + pos[i] - pos[i-1]); // already down inside lim[i]
        }
        for (int i = m-2; i >= 1; i--) {
            h[i] = Math.min(h[i], h[i+1] + pos[i+1] - pos[i]);
        }
        
        int rets = 0;
        // y = (p[i]-p[i-1]) - (h[i] - h[i-1]) / 2
        for (int i = 1; i < m; i++) {
            int peak = h[i] + (h[i-1]-h[i]-(pos[i-1]-pos[i]))/2;
            rets = Math.max(rets, peak);
        } 
        // last valid pos to last n-1
        rets = Math.max(rets, h[m-1] + (n-pos[m-1]));

        return rets;
    }
}
// two path:
// left - right: h[i] - h[i-1] <= p[i] - p[i-1]
// right -> left: h[i] - h[i+1] <= p[i+1] - p[i]
// between limit pos i-1 and i
// there is peak on the middle
// h[i-1] + x = h[i] + y (height)  -> x-y = h[i] - h[i-1] = peak
// p[i-1] + x = p[i] - y {position} -> x+y = p[i] - p[i-1]
