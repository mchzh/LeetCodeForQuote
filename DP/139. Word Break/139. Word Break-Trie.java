class Solution {
    // dfs + Trie + memo
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
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return false;
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
        
        return dfs(s, 0);
    }
    private boolean dfs(String s, int pos) {
        if (pos == s.length()) return true;
        
        if (memo[pos] == 1) return false;
        
        TrieNode node = root;
        for (int i = pos; i < s.length(); i++) {
            char c = s.charAt(i);
            if (node.next[c-'a'] != null) {
                node = node.next[c-'a'];
                if (node.isEnd && dfs(s, i+1)) return true;
            } else break;
        }
        
        memo[pos] = 1;
        return false;
    }
}
