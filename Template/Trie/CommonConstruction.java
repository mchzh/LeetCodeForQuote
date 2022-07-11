class MagicDictionary {
    class TrieNode {
        char val;
        TrieNode[] children;
        boolean isWord;
        public TrieNode(char c) {
            this.val = c;
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }
    TrieNode root;
    public MagicDictionary() {
        root = new TrieNode('#');
    }
    
    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            insertWord(s);
        }
    }
    private void insertWord(String s) {
        TrieNode node = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (node.children[c-'a'] == null) {
                node.children[c-'a'] = new TrieNode(c);
            }
            node = node.children[c-'a'];
        }
        node.isWord = true;
    }
    
    public boolean search(String searchWord) {
        return searchWord(searchWord);
    }
    private boolean searchWord(String s) {
        TrieNode node = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (node.children[c-'a'] == null) {
                return false;
            }
            node = node.children[c-'a'];
        }
        return node.isWord;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
