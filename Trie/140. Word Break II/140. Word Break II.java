class Solution {
    class TrieNode {
        boolean isEnd;
        TrieNode[] next;
        public TrieNode() {
            isEnd = false;
            next = new TrieNode[26];
        }
    }
    TrieNode root;
    int[] memo;
    List<String> rets;
    public List<String> wordBreak(String s, List<String> wordDict) {
        rets = new ArrayList<>();
        if (s == null || s.length() == 0) return rets;
        root = new TrieNode();
        memo = new int[s.length()];
        for (String w : wordDict) {
            TrieNode node = root;
            for (int i = 0; i < w.length(); i++) {
                char c = w.charAt(i);
                if (node.next[c-'a'] == null) node.next[c-'a'] = new TrieNode();
                node = node.next[c-'a'];
            }
            node.isEnd = true;
        }
        
        dfs(s, 0, "");
        return rets;
    }

    private boolean dfs(String s, int pos, String cur) {
        if (pos == s.length()) {
            rets.add(cur);
            return true;
        }
        
        if (memo[pos] == 1) return false;
        
        TrieNode node = root;
        int flag = 0;
        for (int i = pos; i < s.length(); i++) {
            char c = s.charAt(i);
            if (node.next[c-'a'] != null) {
                node = node.next[c-'a'];
                if (node.isEnd) {
                    flag = 1;
                    dfs(s, i+1, cur + (cur.equals("") ? "" : " ") + s.substring(pos, i+1));
                }
            } else break;
        }
        
        if (flag == 1) return true;
        else {
            memo[pos] = 1;
            return false;
        }
    }
}
