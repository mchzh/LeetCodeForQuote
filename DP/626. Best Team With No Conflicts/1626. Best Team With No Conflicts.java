class Solution {
    // https://leetcode.com/problems/best-team-with-no-conflicts/discuss/899631/Java-first-double-sort-then-DP
    // dfs + memo
    public int bestTeamScore(int[] scores, int[] ages) {
        int N = scores.length;
        int[][] relate = new int[N][2];
        for (int i = 0; i < N; i++) {
            relate[i][0] = ages[i];
            relate[i][1] = scores[i];
        }
        Arrays.sort(relate, (a, b) -> ( a[0] == b[0] ? a[1]-b[1] : a[0]-b[0] ));
        
        // lis
        // score dp
        int[] dp = new int[N]; // max end with current idx
        dp[0] = relate[0][1];
        for (int i = 1; i < N; i++) {
            int max = relate[i][1];
            for (int j = 0; j < i; j++) {
                if (relate[i][1] >= relate[j][1]) {
                    max = Math.max(max, dp[j] + relate[i][1]);
                }
            }
            dp[i] = max;
        }
        
        int ret = 0;
        for (int d : dp) {
            ret = Math.max(ret, d);
        }
        return ret;
    }
}
