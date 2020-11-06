class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE/2);
        dp[0] = 1;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if ( isPal(s, j, i) ) {
                    if (j-1 < 0) {
                        dp[i] = 1;
                    } else {
                        dp[i] = Math.min(dp[i], dp[j-1]+1);
                    }
                }
            }
        }
        return dp[n-1]-1;
    }
    private boolean isPal(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}


// X X X X X X X i
// [X X         j-1][j    i]

// dp[i] : the minimum cuts needed for a palindrome partitioning of s[1...i]
// dp[i] = min(dp[j-1]+1), j .st [0, i]
// aab
//aaaabc
