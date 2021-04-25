class Solution {
    // BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordset = new HashSet<>();
        wordset.add(beginWord);
        for (String w : wordList) wordset.add(w);
        Map<String, List<String>> map = new HashMap<>();
        for (String vword : wordset) {
            char[] curs = vword.toCharArray();
            for (int i = 0; i < vword.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (curs[i] == c) continue;
                    char temp = curs[i];
                    curs[i] = c;
                    if (wordset.contains(String.valueOf(curs))) map.computeIfAbsent(vword, k -> new ArrayList<>()).add(String.valueOf(curs));
                    curs[i] = temp;
                }
            }
        }
        
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        
        int level = 0;
        while (!q.isEmpty()) {
            level++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(endWord)) return level;
                if (!map.containsKey(cur)) continue;
                for (String nextWord : map.get(cur)) {
                    if (visited.contains(nextWord)) continue;
                    q.offer(nextWord);
                    visited.add(nextWord);
                }
            }
            //level++;
        }
        return 0;
    }
}
