class Solution {
    int tsum = 0;
    int total = 0;
    int[][][] dp;
    double avg = 0.0;
    public boolean splitArraySameAverage(int[] A) {
        Arrays.sort(A);
        total = A.length;
        for (int a : A) tsum += a;
        avg = 1.0*tsum / total;
        dp = new int[total][tsum+1][total+1];
        for (int[][] d : dp) {
            for (int[] x : d) {
                Arrays.fill(x, -1);
            }
        }
        return dfs(0, A, 0, 0);
    }
    private boolean dfs(int pos, int[] A, int sum, int num) {
        if (num != 0 && num != A.length && total*sum == tsum*num) return true;
        if (pos == A.length) {
            return false;
        }
        
        if (dp[pos][sum][num] != -1) return dp[pos][sum][num] == 1 ? true : false;
        boolean cur = (dfs(pos+1, A, sum+A[pos], num+1) || dfs(pos+1, A, sum, num));
        dp[pos][sum][num] = cur == true ? 1 : 0;
        return dp[pos][sum][num] == 1 ? true : false;
    }
}

// (x1 + x2 + ... + xn)/ n = avg
// (a1 + .. + am) / n1 == (b1+...+bl) / n2 == avg1  (n1+n2 = n , a1+...+am+b1+...bl == (x1+...xn))
// => n*avg = (n1+n2)*avg1 => avg == avg1
// n is total sum
// n/total == sum/num
// n*num == total*sum 
