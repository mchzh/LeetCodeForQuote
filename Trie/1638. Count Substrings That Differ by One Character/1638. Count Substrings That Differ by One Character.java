class Solution {
    // trie search and insert
    // consider dp
    class TrieNode {
        int count;
        boolean isWord;
        TrieNode[] children;
        
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    public int countSubstrings(String s, String t) {
        root = new TrieNode();
        int m = t.length();
        // get every substring of t
        for (int i = 0; i <m; i++) {
            for (int j = i; j < m; j++) {
                String strb = t.substring(i, j+1);
                insert(strb);
            }
        }
        
        int n = s.length();
        Map<String, Integer> map = new HashMap<>();
        int rets = 0;
        // get every substring of s
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String stra = s.substring(i, j+1);
                // replace this string with one different char
                char[] chrs = stra.toCharArray();
                for (int k = 0; k < chrs.length; k++) {
                    char temp = chrs[k];
                    for (char rec ='a'; rec <= 'z'; rec++) {
                        if (rec == temp) continue;
                        chrs[k] = rec;
                        String replace = String.valueOf(chrs);
                        if (map.containsKey(replace)) {
                            rets += map.get(replace);
                            continue;
                        }
                        TrieNode curNode = search(replace);
                        
                        if (curNode != null && curNode.isWord == true) {
                            map.put(replace, curNode.count);
                            rets += curNode.count;
                        }
                    }
                    chrs[k] = temp;
                }
            }
        }
        return rets;
    }
    private void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c-'a'] == null) {
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c-'a'];
        }
        node.count++;
        node.isWord = true;
    }
    private TrieNode search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c-'a'] == null) {
                return null;
            }
            node = node.children[c-'a'];
        }
        return node;
    }
}
