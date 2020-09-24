class WordFilter {
    // two trie
    // paired trie
    // trie of suffix wrapped words

    class TrieNode {
        TrieNode[] children;
        int val;
        public TrieNode() {
            children = new TrieNode[27];
            val = 0;
        }
    }
    
    TrieNode trie;
    
    public WordFilter(String[] words) {
        this.trie = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            for (int j = words[i].length(); j >= 0; j--) {
                String insert = (j < words[i].length() ? words[i].substring(j) : "") + "{" + words[i];
                //System.out.println("add string -> " + insert);
                addToTrie(insert, i);
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        String pattern = suffix+"{"+prefix;
        // find this pattern
        return find(pattern);
    }
    
    private void addToTrie(String strs, int pos) {
        TrieNode cur = trie;
        for (int i = 0; i < strs.length(); i++) {
            
            char ch = strs.charAt(i);
            if (cur.children[ch-'a'] == null) {
                cur.children[ch-'a'] = new TrieNode();
            }
            cur = cur.children[ch-'a'];
            cur.val = Math.max(cur.val, pos);
        }
    }
    private int find(String strs) {
        TrieNode cur = trie;
        for (int i = 0; i < strs.length(); i++) {
            char ch = strs.charAt(i);
            //System.out.println(strs + " " + ch + " " + (ch-'a'));
            if (cur.children[ch-'a'] == null) {
                return -1;
            }
            cur = cur.children[ch-'a'];
        }
        return cur.val;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */

// apple:

// '#apple', 'e#apple', 'le#apple', ... , 'apple#apple'
