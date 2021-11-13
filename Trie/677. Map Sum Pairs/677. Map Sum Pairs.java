class MapSum {
    // trie + map
    Map<String, Integer> map;
    class TrieNode {
        int sum;
        TrieNode[] children;
        public TrieNode() {
            this.sum = 0;
            this.children = new TrieNode[26];
        }
    }
    TrieNode root;
    public MapSum() {
        map = new HashMap<>();
        root = new TrieNode();
    }
    
    private void insertTrie(String str, int val) {
        TrieNode node = root;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (node.children[c-'a'] == null) {
                node.children[c-'a'] = new TrieNode();
            }
            node.children[c-'a'].sum += val;
            //System.out.println(c + " " + node.children[c-'a'].sum);
            node = node.children[c-'a'];
        }
    }

    private int search(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (node.children[c-'a'] == null) {
                return 0;
            }
            node = node.children[c-'a'];
        }
        return node.sum;
    }
    
    public void insert(String key, int val) {
        int update = 0;
        if (map.containsKey(key)) {
            update = val - map.get(key);
        } else update = val;
        map.put(key, val);
        insertTrie(key, update);
    }
    
    public int sum(String prefix) {
        return search(prefix);
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
