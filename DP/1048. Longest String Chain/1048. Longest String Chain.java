class Solution {
    // https://leetcode.com/problems/longest-string-chain/discuss/294890/C%2B%2BJavaPython-DP-Solution
    // https://leetcode.com/problems/longest-string-chain/discuss/294918/DP-with-HashMap-in-JAVA
    public int longestStrChain(String[] words) {
        if (words == null || words.length == 0) return 0;
        // map for chain
        Arrays.sort(words, (w1, w2) -> (w1.length() - w2.length()) );
        Map<String, Integer> map = new HashMap<>();
        
        int ret = 0;
        for (String word : words) {
            if (map.containsKey(word)) continue;
            map.put(word, 1);
            // every step from larger word to smaller word
            for (int i = 0; i < word.length(); i++) {
                String next = word.substring(0, i) + word.substring(i+1);
                if (map.containsKey(next) && map.get(next) + 1 > map.get(word)) {
                    map.put(word, map.get(next) + 1);
                }
            }
            ret = Math.max(ret, map.get(word));
        }
        return ret;
    }
}

/*class Solution {
    public int longestStrChain(String[] words) {
        // dp
        // bfs
        List<HashSet<String>> list = new ArrayList<>();
        for (int i = 0; i <= 17; i++) {
            list.add(new HashSet<String>());
        }
        for (String word : words) {
            list.get(word.length()).add(word);
        }
        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            // dfs
            Queue<String> queue = new LinkedList<>();
            HashSet<String> set = list.get(i);
            for (String first : set) {
                queue.offer(first);
            }
            int start = i;
            int level = 0;
            while (!queue.isEmpty()) {
                level++;
                int size = queue.size();
                for (int j = 0;j < size; j++) {
                    String curr = queue.poll();
                    Iterator<String> it = list.get(start+level).iterator();
                    while (it.hasNext()) {
                        String temp = it.next();
                        if (isPre(curr, temp)) {
                            queue.offer(temp);
                            it.remove();
                        }
                    }
                }
                res = Math.max(res, level);
            }
        }
        return res;
    }
    public boolean isPre(String curr, String compare) {
        if (curr.length() != compare.length()-1) {
            return false;
        }
        for (int i = 0;i < curr.length(); i++) {
            if (curr.charAt(i) != compare.charAt(i)) {
                return curr.substring(i).equals(compare.substring(i+1));
            }
        }
        return true;
    }
}*/
