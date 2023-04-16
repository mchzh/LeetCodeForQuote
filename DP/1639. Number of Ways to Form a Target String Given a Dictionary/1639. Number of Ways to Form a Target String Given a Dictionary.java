class Solution {
    long[][] dp = new long[1005][1005];
    long[][] count = new long[1005][27];
    long mod = (long)(1e9 + 7);
    public int numWays(String[] words, String target) {
        int n = target.length();
        int m = words[0].length();
        target = "#" + target;
        for (String w : words) {
            for (int i = 0; i < m; i++) {
                char c = w.charAt(i);
                count[i+1][c-'a']++;
            }
        }
        //intital value
        // dp[i][0] : 0 no word 
        // dp[0][t] : 1 word to produce empty;
        for (int i = 0; i <= m; i++) dp[0][i] = 1;

        for (int i = 1; i <= n; i++) {
            for (int t = 1; t <= m; t++) {
                dp[i][t] = dp[i][t-1];
                char c = target.charAt(i);
                if (count[t][c-'a'] > 0) {
                    dp[i][t] += dp[i-1][t-1]*count[t][c-'a']%mod;
                }
                dp[i][t] %= mod;
            }
        }

        return (int)dp[n][m];
    }
}

// word: X X X X X k X X X X
// target: Y Y Y Y i Y. Y Y Y

// dp[i][k]: the number of ways on target with [0...i] and words [0...k]
// 1. not select the kth char
// dp[i][k] = dp[i][k-1];
// 2. select the kth char
// if (can do that) {
//     dp[i][k] = dp[i-1][k-1] * count(char i on k pos)
// }
