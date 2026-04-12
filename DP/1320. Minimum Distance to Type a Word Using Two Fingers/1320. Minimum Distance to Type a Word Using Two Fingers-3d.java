class Solution {
    public int minimumDistance(String word) {
        int n = word.length();
        int[][][] dp = new int[n][26][26];
        // java stream to set initial value
        Arrays.stream(dp).forEach(w -> 
            Arrays.stream(w).forEach(chr -> 
                Arrays.setAll(chr, i -> Integer.MAX_VALUE/2)
            )
        );
        
        int ch0 = word.charAt(0) - 'A';
        for (int i = 0; i < 26; i++) {
            dp[0][ch0][i] = 0;
        }
        for (int i = 0; i < 26; i++) {
            dp[0][i][ch0] = 0;
        }

        for (int k = 1; k < n; k++) {
            int ch = word.charAt(k) - 'A';
            for (int i = 0; i < 26; i++) {
                 for (int j = 0; j < 26; j++) {
                    dp[k][ch][i] = Math.min(dp[k][ch][i], dp[k-1][j][i] + dist(j, ch));
                 }
            }
            for (int i = 0; i < 26; i++) {
                 for (int j = 0; j < 26; j++) {
                    dp[k][i][ch] = Math.min(dp[k][i][ch], dp[k-1][i][j] + dist(j, ch));
                 }
            }
        }
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            ret = Math.min(ret, dp[n-1][word.charAt(n-1) - 'A'][i]);
        }
        for (int i = 0; i < 26; i++) {
            ret = Math.min(ret, dp[n-1][i][word.charAt(n-1) - 'A']);
        }
        return ret;
    }

    private int dist(int a, int b) {
        int x1 = a/6;
        int y1 = a%6;
        int x2 = b/6;
        int y2 = b%6;

        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }
}
// dp[i][j][k]; 1 f on i-th char, and 2 f on j-th char([0, 26]) at word[0...k] 
// ch = word[k]
// dp[k][i][j] -> dp[k][i`][j`]
// k-1: fix j [il][j] 
// ch on left finger
// for (int i = 0; i < 26; i++) {
//     dp[k][ch][i] = min(dp[k-1][j][i] + dis(j, ch));
// }
// ch on right finger
// for (int i = 0; i < 26; i++) {
//     dp[k][i][ch] = min(dp[k-1][i][j] + dis(j, ch));
// }
// rets
// for (int i = 0; i < 26; i++) {
//     ret = min(dp[n-1][word[n-1]][i]);
// }
// for (int i = 0; i < 26; i++) {
//     ret = min(dp[n-1][i][word[n-1]]);
// }
