class Solution {
    //dfs + backtracking
    // https://leetcode.com/problems/word-pattern-ii/discuss/73664/Share-my-Java-backtracking-solution
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        return isMatch(str, 0, pattern, 0, map, set);
    }
    private boolean isMatch(String str, int i, String pat, int j, Map<Character, String> map, Set<String> set) {
        // corner case
        if (i == str.length() && j == pat.length()) return true;
        if (i == str.length() || j == pat.length()) return false;
        
        char c = pat.charAt(j);
        if (map.containsKey(c)) {
            String cur = map.get(c);
            if (!str.startsWith(cur, i)) return false;
            
            return isMatch(str, i+cur.length(), pat, j+1, map, set);
        }
        // no exist
        for (int k = i; k < str.length(); k++) {
            String recur = str.substring(i, k+1);
            if (set.contains(recur)) {
                continue;
            }
            
            // create and update it
            map.put(c, recur);
            set.add(recur);
            if (isMatch(str, k+1, pat, j+1, map, set)) return true;
            // backtracking
            map.remove(c);
            set.remove(recur);
        }
        
        // we've tried out best but still not luck
        return false;
    }
}
