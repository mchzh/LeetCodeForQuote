class Solution {
    public int palindromePartition(String s, int k) {
        int n = s.length();
        s = "#" + s;
        int[][] dp = new int[n+1][k+1];
        for (int[] d : dp) {
            Arrays.fill(d, Integer.MAX_VALUE/2);
        }
        
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int t=1; t <= Math.min(i, k); t++) {
                for (int j = t; j <= i; j++) {
                    //if () {}
                    dp[i][t] = Math.min(dp[i][t], dp[j-1][t-1] + helper(s, j, i));
                }
            }
        }
        return dp[n][k];
    }
    private int helper(String str, int left, int right) {
        int count = 0;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) count++;
            left++;
            right--;
        }
        return count;
    }
}

// dp[i][k] : the minimal number of characters that you need to change to divide the string[0...i] to k substring which each substring is palidrome.

// X X X Xj-1] [jX X i]
//         k-1

// dp[i][k] = min(dp[j-1][k-1] + helper(s, j, i)); 0<=j <= i;

// for (int i = 1; i <= n; i++) {
//     for (int k=1; k <= min(i, K); k++) {
//         for (int j = k; j <= i; j++) {
//             dp[i][k] = min(dp[i][k], dp[j-1][k-1] + helper(s, j, i));
//         }
//     }
// }
// return dp[n][k];
