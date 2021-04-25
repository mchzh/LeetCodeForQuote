class Solution {
    class TrieNode {
        boolean isEnd;
        TrieNode[] next;
        int count;
        public TrieNode() {
            next = new TrieNode[26];
            isEnd = false;
            count = 0;
        }
    }
    TrieNode root;
    Set<String> rets;
    boolean[][] visited;
    // improvement : delete node after visited
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length, n = board[0].length;
        visited = new boolean[m][n];
        root = new TrieNode();
        rets = new HashSet<>();
        for (String w : words) {
            TrieNode node = root;
            for (char c : w.toCharArray()) {
                if (node.next[c-'a'] == null) node.next[c-'a'] = new TrieNode();
                node = node.next[c-'a'];
                node.count += 1;
            }
            node.isEnd = true;
        }
        
        for (int i= 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                TrieNode node = root;
                visited[i][j] = true;
                dfs(board, i, j, node, "");
                visited[i][j] = false;
            }
        }
        return new ArrayList<>(rets);
    }
    private void dfs(char[][] board, int x, int y, TrieNode node, String word) {
        if (node.next[board[x][y]-'a'] == null) return;
        node = node.next[board[x][y]-'a'];
        if (node.count == 0) return;
        word += board[x][y];
        if (node.isEnd == true) {
            rets.add(word);
            remove(root, word);
            node.isEnd = false;
        }
        
        int[][] dirs = {{1, 0},{-1, 0},{0, 1},{0, -1}};
        for (int k = 0; k < 4; k++) {
            int cx = x + dirs[k][0];
            int cy = y + dirs[k][1];
            if (cx < 0 || cx >= board.length || cy < 0 || cy >= board[0].length) continue;
            if (visited[cx][cy] == true) continue;
            visited[cx][cy] = true;
            dfs(board, cx, cy, node, word);
            visited[cx][cy] = false;
        }
    }
    private void remove(TrieNode node, String word) {
        for (char c : word.toCharArray()) {
            node = node.next[c-'a'];
            node.count--;
        }
    }
}
