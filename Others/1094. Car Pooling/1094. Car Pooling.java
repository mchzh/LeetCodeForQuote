class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // difference array
        int n = trips.length;
        int[][] diff = new int[2*n][2];
        for (int i = 0; i < n; i++) {
            int[] t = trips[i];
            diff[i][0] = t[1];
            diff[i][1] = t[0];
            diff[i+n][0] = t[2];
            diff[i+n][1] = -t[0];
        }
        
        Arrays.sort(diff, (a, b) -> (a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]));
        int passengers = 0;
        for (int[] d : diff) {
            passengers += d[1];
            if (passengers > capacity) return false;
        }
        return true;
    }
}
