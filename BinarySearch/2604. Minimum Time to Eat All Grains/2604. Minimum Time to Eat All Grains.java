class Solution {
    public int minimumTime(int[] hens, int[] grains) {
        Arrays.sort(hens);
        Arrays.sort(grains);
        int left = 0, right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = left + (right-left)/2;
            if (isOK(hens, grains, (long)mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    private boolean isOK(int[] hens, int[] grains, long time) {
        // double point
        int j = 0;
        int n = grains.length;
        for (int i = 0; i < hens.length; i++) {
            long a = hens[i];
            long t = 0;
            if (grains[j] < a) {
                t = a - grains[j];
                if (t > time) return false; // reach the left most more than current selection
            }
            while (j < n && grains[j] <= hens[i]) {
                j++;
            }

            if (time < 3*t) {
                while (j < n && (t+(grains[j]-a)*2)<=time) {
                    j++;
                }
            } else {
                while (j < n && (2*t+(grains[j]-a))<=time) {
                    j++;
                }
            }

            if (j == n) return true; // eat all
        }
        return false;
    }
}
//   o o
// x x x x
// T - 2*t and (T-t)/2 -> right most pos
// T-2*t > (T-t)/2 => T > 3*t
