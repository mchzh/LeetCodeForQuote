class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long left = 0, right = Long.MAX_VALUE;
        while (left < right) {
            long mid = right - (right - left) / 2;
            long[] temp = new long[n];
            for (int i = 0; i < n; i++) {
                temp[i] = (long)stations[i];
            }

            if (isOK(temp, r, (long)k, mid)) {
                left = mid;
            } else {
                right = mid -1;
            }
        }
        return left;
    }

    private boolean isOK(long[] stations, int r, long k, long mid) {
        int n = stations.length;
        long sum = 0;
        for (int i = 0; i <= r-1; i++) sum += stations[i];

        for (int i = 0; i < n; i++) {
            // slide the window to right 1 postion and out left 1 position
            if (i+r < n) 
                sum += stations[i+r];
            if (i-r-1 >= 0) sum -= stations[i-r-1];

            if (sum >= mid) continue;
            
                long d = mid - sum;
                if (k < d) return false;
                stations[Math.min(n-1, i+r)] += d;
                k -= d;
                sum += d;
            

        }
        return true;
    }
}
// ---- x --- r distance
// k, 
// for every range will reach out binary search current value
// not match to add k into the most right postion on this window subarray
