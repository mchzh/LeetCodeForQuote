class Solution {
    public int minStickers(String[] stickers, String target) {
        // status dp
        int n = target.length();
        int[] dp = new int[(1<<n)];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int i = 0; i < (1<<n); i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;
            for (String s : stickers) {
                int j = findNextStatus(i, target, s);
                dp[j] = Math.min(dp[j], dp[i]+1);
                //System.out.println(j + " " + i + " " + dp[j]);
            }
        }
        
        return dp[(1<<n)-1] == Integer.MAX_VALUE ? -1 : dp[(1<<n)-1];
    }
    private int findNextStatus(int status, String target, String cur) {
        int n = target.length();
        for (char c : cur.toCharArray()) {
            for (int k = 0; k < n; k++) {
                if (((status>>k)&1) == 0 && target.charAt(n-k-1) == c) {
                    status += (1<<k);
                    break;
                }
            }
        }
        return status;
    }
}

// "hello"
// dp[00011111] = dp[31]

// "he"
// dp[00011000]
