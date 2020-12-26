class Solution {
    public int numDecodings(String s) {
        //dp 
        // depends dp[i-1] and dp[i-2]
        int n = s.length();
        s = "0"+s;
        int[] dp = new int[n+1];
        dp[0] = 1; // virtual node
        for (int i = 1; i <= n; i++) {
            if (dp[i-1] == 0) return 0;
            char c = s.charAt(i);
            
            if (c >= '1' && c <= '9') dp[i] += dp[i-1];
            
            if (i > 1 && (s.charAt(i-1)== '1' || (s.charAt(i-1) == '2' && c<='6' ) ) ) {
                dp[i] += dp[i-2];   
            }
        }
        return dp[n];
    }
}
