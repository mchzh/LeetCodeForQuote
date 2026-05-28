class Solution {
    class TrieNode {
        char val;
        boolean isWord;
        TrieNode[] childs;
        int minLen;
        List<Integer> minList;
        // public TrieNode() {
        //     this.val = ' ';
        //     isWord = false;
        //     childs = new TrieNode[26];
        // }
        public TrieNode(char val) {
            this.val = val;
            isWord = false;
            minLen = Integer.MAX_VALUE;
            minList = new ArrayList<>();
            childs = new TrieNode[26];
        }
    }

    TrieNode root = new TrieNode(' ');
    public void add(String str, int idx) {
        int n = str.length();
        TrieNode node = root;
        for (int i = n-1; i >= 0; i--) {
            char c = str.charAt(i);
            // empty
            if (node.childs[c-'a'] == null) {
                node.childs[c-'a'] = new TrieNode(c);
            }
            node = node.childs[c-'a'];
            if (n < node.minLen) {
                node.minLen = n;
                node.minList.clear();
                node.minList.add(idx);
            } else if (n == node.minLen) {
                node.minList.add(idx);
            }
        }
        node.isWord = true;
    }
    public int query(String str) {
        int n = str.length();
        TrieNode node = root;
        for (int i = n-1; i >= 0; i--) {
            char c = str.charAt(i);
            // empty
            if (node.childs[c-'a'] == null) {
                // return false;
                // node.childs[c-'a'] = new TrieNode(c);
                if (node == root) {
                    return wholemin;
                }
                return node.minList.get(0);
            }
            node = node.childs[c-'a'];
        }
        return node.minList.get(0);
    }
    int wholemin = -1;
    // trie
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int n = wordsContainer.length;
        Map<Integer, Integer> idx2len = new HashMap<>();
        int curlen = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            idx2len.put(i, wordsContainer[i].length());
            if (curlen > wordsContainer[i].length()) {
                //System.out.println(curlen+ " : " + wordsContainer[i].length() + " : " + i);
                curlen = wordsContainer[i].length();
                wholemin = i;
            }
        }
        int m = wordsQuery.length;
        int[] rets = new int[m];
        for (int i = 0; i < n; i++) {
            add(wordsContainer[i], i);
        }
        //System.out.println(wholemin);
        for (int i = 0; i < m; i++) {
            rets[i] = query(wordsQuery[i]);
        }
        return rets;
    }
}
// trie: info
// char node[26]
// boolean isword
// list<>: all valid index
// List<>: minlen index
