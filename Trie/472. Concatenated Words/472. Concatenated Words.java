class Solution {
    // enhance word break: dfs+memo+trie
    class TrieNode {
        boolean isEnd;
        TrieNode[] next;
        public TrieNode() {
            next = new TrieNode[26];
        }
    }
    TrieNode root;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> rets = new ArrayList<>();
        if (words == null || words.length == 0) return rets;
        
        root = new TrieNode();
        Arrays.sort(words, (a, b) -> (a.length() - b.length()));
        for (String w : words) {
            if (w == null || w.length() == 0) continue;
            if (check(w)) rets.add(w);
            // insert this word into trie
            TrieNode node = root;
            for (int i = 0; i < w.length(); i++) {
                char c = w.charAt(i);
                if (node.next[c-'a'] == null) node.next[c-'a'] = new TrieNode();
                node = node.next[c-'a'];
            }
            node.isEnd = true;
        }
        return rets;
    }
    private boolean check(String word) {
        int[] visited = new int[word.length()];
        return dfs(word, 0, visited);
    }
    private boolean dfs(String word, int pos, int[] visited) {
        if (pos == word.length()) return true;
        if (visited[pos] == 1) return false;
        TrieNode node = root;
        for (int i = pos; i < word.length(); i++) {
            char c = word.charAt(i);
            
            if (node.next[c-'a'] != null) {
                node = node.next[c-'a'];
                if (node.isEnd && dfs(word, i+1, visited)) return true;
            } else {
                break;
            }
        }
        visited[pos]=1;
        return false;
    }
}
