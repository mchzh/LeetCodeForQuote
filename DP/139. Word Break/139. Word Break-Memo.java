class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // dp: dfs + memo
        if (s == null || s.length() == 0) return false;
        Set<String> set = new HashSet<>();
        Map<Integer, Boolean> memo = new HashMap<>();
        for (String w : wordDict) set.add(w);
        return dfs(s, 0, set, memo);
    }
    private boolean dfs(String s, int pos, Set<String> set, Map<Integer, Boolean> memo) {
        if (pos == s.length()) return true;
        if (memo.containsKey(pos)) return memo.get(pos);
        for (int i = pos; i < s.length(); i++) {
            String cur = s.substring(pos, i+1);
            if (set.contains(cur)) {
                if (dfs(s, i+1, set, memo)) {
                    memo.put(pos, true);
                    return true;
                }
            }
        }
        memo.put(pos, false);
        return false;
    }
}
