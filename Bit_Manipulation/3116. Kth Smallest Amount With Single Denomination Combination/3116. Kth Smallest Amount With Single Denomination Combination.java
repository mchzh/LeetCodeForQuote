class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long left = 1; long right = Long.MAX_VALUE;
        while (left < right) {
            long mid = left + (right-left)/2;
            long curr = countNum(mid, coins);
            if (curr >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
            //System.out.println(left + " : " + right + " : " + mid + " : " + curr);
        }
        return left;
    }

    private long countNum(long mid, int[] coins) {
        int m = coins.length;

        long sign = 1;
        long rets = 0;
        for (int k = 1; k <= m; k++) {
            int state = (1 << k) - 1;

            long sum = 0;           
            while (state < (1 << m))
            {
                // get all count of part
                // get lcm them m/lcm is couont for all current combination
                long lcm = 1;
                for (int i = 0; i < m;i++) {
                    // state move bit
                    if (((state>>i)&1) == 1) {
                        lcm = getLCM(lcm, coins[i]);
                    }
                }
                sum += mid/lcm;

                int c = state & - state;
                int r = state + c;
                state = (((r ^ state) >> 2) / c) | r;
            }
            
            rets += sign * sum;
            sign = (-1)*sign;
        }
        
        
        return rets;
    }


    private long getGCD(long a, long b) {
        if (a == 0 || b == 0) return a+b;
        return getGCD(b, a%b);
    }
    private long getLCM(long a, long b) {
        long gcd = getGCD(a, b);
        return (a/gcd * b /gcd) * gcd;
    }
}

// 容斥原理
