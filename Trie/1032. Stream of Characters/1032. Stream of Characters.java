class StreamChecker {
    class TrieNode {
        boolean isWord;
        TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }
    
    TrieNode root;
    String str;
    
    public StreamChecker(String[] words) {
        root = new TrieNode();
        str = "";
        for (String w :words) {
            addWord(w);
        }
    }
    
    public boolean query(char letter) {
        str += letter;
        if (find(str)) return true;
        else return false;
    }
    
    private void addWord(String word) {
        TrieNode node = root;
        for (int i = word.length()-1; i >= 0; i--) {
            char c = word.charAt(i);
            if (node.children[c-'a'] == null) {
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c-'a'];
        }
        node.isWord = true;
    }
    
    private boolean find(String str) {
        //System.out.println(str);
        TrieNode node = root;
        int idx = str.length()-1;
        while (idx >= 0) {
            char cur = str.charAt(idx);
            
            if (node.children[cur-'a'] != null) {
                node = node.children[cur-'a'];
                if (node.isWord) return true;
                idx--;
            } else {
                return false;
            }
            
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
