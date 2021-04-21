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
            // match the suffix of s[0:i]
            for (String str : set) {
                int size = str.length();
                if (i >= size && s.substring(i-size+1, i+1).equals(str) && dp[i-size]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
