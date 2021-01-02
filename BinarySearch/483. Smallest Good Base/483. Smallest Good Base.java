class Solution {
    public String smallestGoodBase(String n) {
       
        long Tar = Long.valueOf(n);
        for (int m = (int)(Math.log(Tar+1)/ Math.log(2)+1); m >= 1; m--) {
            // k is base
            long left = 2;
            long right = (long)Math.pow(Tar, 1.0/(m-1))+1;
            
            // binary search to make sure the upper bound
            while (left <= right) {
                long mid = left + (right - left) / 2;
                // mid is the current base
                long k = mid;
                long sum = 1;
                
                for (int i = 1; i < m; i++) {
                    sum = sum*k + 1;
                    
                }
                
                if (sum == Tar) return String.valueOf(mid);
                else if (sum > Tar) {
                    right = mid-1;
                } else left = mid+1;
            }
        }
        return String.valueOf(Tar-1);
    }
}

// N-1 is a solution => 11
    
// n = k^0 + k^1 + ..... = k^(m-1)
// n = (k^m-1) /(k-1)  m i k d  => this is a increasing function can use binary search
// n*(k-1)+1 = k^m
// n*k - n+1 = k^m (-n+1 is a large negative)
// n*k > k^m
// n > k^(m-1)
// k < pow(n, 1/(m-1))  -> upper bound for k
