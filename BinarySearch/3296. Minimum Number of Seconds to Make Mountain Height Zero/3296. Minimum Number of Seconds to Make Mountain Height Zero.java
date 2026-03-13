class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int n = workerTimes.length;
        long lo = 1, hi = Long.MAX_VALUE; // value
        while (lo < hi) {
            long mid = lo + (hi-lo)/2;
            
            if (isOk(mid, mountainHeight, workerTimes)) {
                // can move down
                hi = mid;
            } else {
                // have to move up more than 1
                lo = mid+1;
            }
        }
        
        return lo;
    }
    

    private boolean isOk(long T, int mountainHeight, int[] workerTimes) {
        long curHeight = (long)mountainHeight;
        int n = workerTimes.length;
        
        for (int i = 0; i < n; i++) {
            long maxreduceheight = T/(long)(workerTimes[i]); //maxreduceheight=k*(k+1)/2
            if (maxreduceheight == 0) continue;
            long k = getReduceHeight(maxreduceheight, curHeight);

            if (curHeight <= k) return true;
            curHeight -= k;
        }
        return false;
    }
    private long getReduceHeight(long tar, long right) {
        long left = 1;
        while (left < right) {
            long mid = right - (right - left)/2;
            if (mid*(mid+(long)1)/(long)2 <= tar) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

}
// T : the seconds to reduce mountain as 0 > any worktime[i]
// height[i] = T/workerTime[i];= n >= k*(k+1)/2
// 2*n >= k*(k+1) -> max k with binary search -> k is current reduced height of mountain
// max boundar is 10^15 > 2^32 and < 2^64
