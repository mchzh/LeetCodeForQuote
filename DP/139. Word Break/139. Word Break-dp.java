class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return false;
        Set<String> set = new HashSet<String>();
        for (String w : wordDict) set.add(w);
        int n = s.length();
        s = "#" + s;
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                String cur = s.substring(j, i+1);
                if (set.contains(cur)) dp[i] |= dp[j-1];
            }
        }
        return dp[n];
    }
}
