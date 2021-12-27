class Solution {
    // word break
    // dfs(TLE) or dp or trie
    // trie + dfs + memo
    class TrieNode {
        TrieNode[] next;
        boolean isEnd;
        public TrieNode() {
            isEnd = false;
            next = new TrieNode[26];
            // for (int i = 0; i < 26; i++) {
            //     next[i] = null;
            // }
        }
    }
    TrieNode root;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        root = new TrieNode();
        Arrays.sort(words, (a, b) -> (a.length() - b.length()));

        List<String> rets = new ArrayList<>();
        for (String w : words) {
            //System.out.println(w + " " + w.length());
            if ( !w.equals("") && check(w) ) {
                rets.add(w);
            }
            // add cur stirng into trie
            TrieNode node = root;
            for (int i = 0; i < w.length(); i++) {
                char c = w.charAt(i);
                if (node.next[c-'a'] == null) {
                    node.next[c-'a'] = new TrieNode();
                }
                node = node.next[c-'a'];
            }
            node.isEnd = true;
        }

        return rets;
    }

    private boolean check(String str) {
        int[] visited = new int[str.length()];
        return dfs(str, 0, visited);
    }

    private boolean dfs(String str, int pos, int[] visited) {
        // base case
        if (pos == str.length()) return true;

        if (visited[pos] == 2) {
            return false;
        }

        TrieNode node = root;
        for (int i = pos; i < str.length(); i++) {
            char c = str.charAt(i);
            if (node.next[c-'a'] != null) {
                node = node.next[c-'a'];
                if (node.isEnd && dfs(str, i+1,visited)) {
                    return true;
                }
            } else {
                break;
            }
        }
        visited[pos] = 2;
        return false;
    }
}
