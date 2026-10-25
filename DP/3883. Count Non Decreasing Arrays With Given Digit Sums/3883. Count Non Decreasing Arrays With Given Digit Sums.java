class Solution {
    // n is the digitSum length
    public int countArrays(int[] digitSum) {
        long mod = (long)(1e9+7);
        int n = digitSum.length;
        Map<Integer, List<Integer>> digitgroup = new HashMap<>();
        for (int i = 0; i < 5001; i++) {
            int a = getSum(i);
            digitgroup.computeIfAbsent(a, k -> new ArrayList<>()).add(i);
        }

        long[][] dp = new long[n][5001];
        long[] presum = new long[5001];
        if (!digitgroup.containsKey(digitSum[0])) return 0;

        List<Integer> initgroup = digitgroup.get(digitSum[0]);
        for (int c : initgroup) {
            dp[0][c] = 1L;
        }
        for (int j = 0;  j < 5001; j++) {
            presum[j] = ((j==0) ? 0 : presum[j-1]) + dp[0][j];
        }

        for (int i =1; i < n; i++) {
            if (!digitgroup.containsKey(digitSum[i])) return 0;
            List<Integer> curgroup = digitgroup.get(digitSum[i]);
            //if (curgroup == null) return 0;
            for (int c : curgroup) {
                dp[i][c] = presum[c];
                dp[i][c] %= mod;
            }
            for (int j = 0;  j< 5001; j++) {
                presum[j] = ((j==0) ? 0 : presum[j-1]) + dp[i][j];
                presum[j] %= mod;
            }
        }
        long rets = 0;
        for (int i =0; i < 5001; i++) {
            rets += dp[n-1][i];
            rets %= mod;
        }
        return (int)rets;
    }
    private int getSum(int x) {
        int sum = 0;
        while (x != 0) {
            sum += (x%10);
            x /= 10;
        }
        return sum;
    }
}

// dp[i][x]: the distinct ways of arrays with valude x end with i
// if digitsum(x) == digitSum[i]; dp[i][x] = dp[i-1][y0]+ dp[i-1][y1]......+ dp[i-1][ym];
// y0,....., ym <= x (with presum dp: presum[ym] - presum[0])
// if not equals: dp[i][x] = 0;
