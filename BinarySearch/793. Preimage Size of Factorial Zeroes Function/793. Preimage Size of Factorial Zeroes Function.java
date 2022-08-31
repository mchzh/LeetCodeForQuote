class Solution {
    public int preimageSizeFZF(int k) {
        long left = 1, right = Long.MAX_VALUE;
        while (left < right) {
            long mid = left + (right-left)/2;
            
            long ctz = countTrailZero(mid);
            if (ctz < k) {
                left = mid+1;
            } else if (ctz > k) {
                right = mid-1;
            } else {
                right = mid;
            }
        }
        if (left < right) return 0;
        if (left == right) {
            if (countTrailZero(left) == k) return 5;
            else return 0;
        }
        return 0;
    }
    
    private long countTrailZero(long x) {
        long count = 0;
        for (long i = 5; i <= x; i = i*5) {
            count += x/i;
        }
        return count;
    }
}

// f(x) = x/5 + x/25 + x/125 + .... + 0
    
// f(25) = 6
// f(24) = 4
// K = 5 not exist x
