class WordDictionary {

    class TrieNode {
        char ch;
        TrieNode[] childrens;
        boolean isWord;
        public TrieNode() {
            ch = ' ';
            childrens = new TrieNode[26];
            isWord = false;
        }
        public TrieNode(char ch) {
            this.ch = ch;
            childrens = new TrieNode[26];
            isWord = false;
        }
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.childrens[c-'a'] == null) node.childrens[c-'a'] = new TrieNode(c);
            node = node.childrens[c-'a'];
        }
        node.isWord = true;
        //System.out.println("add finish -> " + node.ch);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode node = root;
        return dfs(word, node);
    }
    private boolean dfs(String str, TrieNode curNode) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '.') {
                //System.out.println("next node . -> " + curNode.ch);
                // dfs search
                for (TrieNode nextNode : curNode.childrens) {
                    //System.out.println("next node reference -> " + nextNode);
                    if (nextNode == null) continue;
                    //System.out.println("next node recursion -> " + nextNode.ch);
                    if (dfs(str.substring(i+1), nextNode)) return true;
                }
                return false;
            }
            else {
                if (curNode.childrens[c-'a'] != null) {
                    curNode = curNode.childrens[c-'a'];
                } else return false;
            }
        }
        return curNode.isWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

/*class Trie{
    Trie[] children;

    boolean isWord;
    
    public Trie(){
        this.children = new Trie[26];

        this.isWord = false;
    }
}

class WordDictionary {
    
    Trie root;
    public WordDictionary() {
        this.root = new Trie();
    }
    
    public void addWord(String word) {
        Trie cur = root;
        
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new Trie();
            }
            cur = cur.children[c - 'a'];
        }
        
        cur.isWord = true;
        
    }
    
    public boolean search(Trie cur, String word, int i) {
        if (i == word.length() ) {
            return cur.isWord;
        }
            char c = word.charAt(i);
            
            if (c == '.') {
                for (Trie child: cur.children) {
                    if (child != null && search(child, word, i + 1)) {
                        return true;
                    }
                }
                return false;
            }else{
                
                if (cur.children[c - 'a'] != null && search(cur.children[c - 'a'], word, i + 1)) {
                    return true;
                }
            }

        return false;
    }
    
    public boolean search(String word) {
        
        
        return search(root, word, 0);
    }
}*/
