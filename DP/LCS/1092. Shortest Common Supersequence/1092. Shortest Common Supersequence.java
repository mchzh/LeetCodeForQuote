class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        // lcs
        int M = str1.length(), N = str2.length();
        int[][] dp = new int[M+1][N+1];
        str1 = "#" + str1;
        str2 = "#" + str2;
        
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        // twp pointer
        int i = M, j = N;
        StringBuilder sb = new StringBuilder();
        while (i > 0 && j > 0) {
            if (str1.charAt(i) == str2.charAt(j)) { // ==
                sb.append(str1.charAt(i));
                i--;
                j--;
            } else if (dp[i][j] == dp[i-1][j]) {
                sb.append(str1.charAt(i));
                i--;
            } else {
                sb.append(str2.charAt(j));
                j--;
            }
        }
        
        while (i > 0) {
            sb.append(str1.charAt(i));
            i--;
        }
        
        while (j > 0) {
            sb.append(str2.charAt(j));
            j--;
        }
        
        return sb.reverse().toString();
    }
}

// X a X c X X X b X X X i
// Y Y a Y c Y b Y j
