class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) return 0;
        int N = s.length();
        int[][] dp = new int[N][N];
        // larger section depend on smaller section
        dp[0][0] = 1;
        for (int len = 1; len <= N; len++) {
            // from start point
            for (int i = 0; i+len-1 < N; i++) {
                int j = i+len-1;
                if (i == j) {
                    dp[i][i] = 1;
                } else if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i+1][j-1] + 2);
                } else {
                    dp[i][j] = Math.max(dp[i][j], Math.max(dp[i][j-1], dp[i+1][j]));
                } // excepiton for i > j, consider dp[i][j]
            }
        }
        return dp[0][N-1];
    }
}
// i xxxxxxx j : 1. si == sj dp[][] + 2; 2. si != sj max(dp[i][j-1], dp[i-1][j]);
// dp[i][j] : the longest palindromic subsequence's length in s[i : j]

/*public class Solution {
    public int longestPalindromeSubseq(String s) {
        if(s==null || s.length()==0) return 0;
        // dp   direction: from botton to top and from left to right
        // dp[i][j] = dp[i+1][j-1] + 2; if s[i] == s[j] 
        //          = Math.max(dp[i+1][j], dp[i][j-1]), otherwise
        // lcs of s and reverse(s)
        int len = s.length();
        int[][] dp = new int[len][len];
        for(int i = len-1; i >= 0; i--) {
            dp[i][i] = 1;
            for(int j = i+1; j < len; j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] +2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][len-1];
    }
    /*public int longestPalindromeSubseq(String s) {
        // dp
        // formula meaning: dp[i][j] the longest palindromic subsequence of substring(i,j) (i <= j)
        // State transition:
        // if s.charAt(i) == s.charAt(j), dp[i][j] = dp[i+1][j-1] + 1
        // otherwise dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
        // Initialization : dp[i][i] = 1;
        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        int[][] dp = new int[len][len];
        int max = 1;
        // initialize
        for(int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        // two loop get substring(i, j)
        for(int i = len - 1; i >= 0; i--) {  // from bottom to top
            for(int j = i+1; j < len; j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}*/
    
/*class Solution {
    public int longestPalindromeSubseq(String s) {
        strg = new int[s.length()][s.length()];
        for(int[] arr: strg){
            Arrays.fill(arr, -1);
        }
        return longestPalindromeSubseq(s ,0, s.length()-1);
    }
    int[][] strg;
    public int longestPalindromeSubseq(String s, int si, int ei){
        if(si==ei){
            return 1;
        }else if(si>ei){
            return 0;
        }
        if(strg[si][ei]!=-1){
            return strg[si][ei];
        }
        char c1 = s.charAt(si);
        char c2 = s.charAt(ei);
        if(c1==c2){
            return strg[si][ei] = longestPalindromeSubseq(s, si+1, ei-1) + 2;
        }else{
            return strg[si][ei] = Math.max(longestPalindromeSubseq(s, si+1, ei), 
                            longestPalindromeSubseq(s, si, ei-1));
        }
        
    }
}*/
