class Solution {
    List<String> rets = new ArrayList<>();
    // https://leetcode.com/problems/generalized-abbreviation/discuss/77190/Java-backtracking-solution
    public List<String> generateAbbreviations(String word) {
        
        int n = word.length();
        for (int i = 0; i < (1<<n); i++) rets.add(abbr(word, i, n));
        // helper(word, 0, "", 0);
        return rets;
    }
    private void helper(String word, int pos, String cur, int count) {
        if (pos == word.length()) {
            cur += (count > 0 ? count : "");
            rets.add(cur);
            return;
        }
        helper(word, pos+1, cur, count+1);
        helper(word, pos+1, cur + (count > 0 ? count : "") + word.charAt(pos), 0);
    }
    private String abbr(String word, int x, int n) {
        StringBuilder sb = new StringBuilder();
        int consective = 0;
        for (int i = 0; i < n; i++) {
            if ( (x&1) == 0 ) { // not abbreviation
                if (consective > 0) {
                    sb.append(consective);
                    consective = 0;
                }
                sb.append(word.charAt(i));
            } else {
                consective++;
            }

            x >>= 1;
        }
        if (consective != 0) sb.append(consective);
        return sb.toString();
    }
}
