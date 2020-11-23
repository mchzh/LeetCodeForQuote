class Solution {
    List<String> rets = new ArrayList<>();
    // https://leetcode.com/problems/generalized-abbreviation/discuss/77190/Java-backtracking-solution
    public List<String> generateAbbreviations(String word) {
        
        int n = word.length();
        helper(word, 0, "", 0);
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
}
