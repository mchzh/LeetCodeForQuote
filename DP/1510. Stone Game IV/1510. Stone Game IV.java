class Solution {
    int[] dp = new int[100001];
    public boolean winnerSquareGame(int n) {
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j*j <= i; j++) {
                if (dp[i-j*j] == 0) {
                    dp[i] = 1;
                    break;
                }
            }
        }
        return dp[n] == 1 ? true : false;
    }
}
// dp[n] = dp[n-1], dp[n-4], dp[n-9],....

/*class Solution {
    public boolean winnerSquareGame(int n) {
        if (n <= 0) throw new IllegalArgumentException("");
        boolean[] m = new boolean[n+1];
        m[0] = false;
        m[1] = true;
        for (int k = 2; k <= n; k++) {
            comp(k, m);
        }
        return m[n];
    }
    
    void comp(int k, boolean[] m) {
        for (int i = 1; i*i <= k; i++) {
            if (!m[k - i*i]) {
                m[k] = true;
                return;
            }
        }
        m[k] = false;
    }
}*/
