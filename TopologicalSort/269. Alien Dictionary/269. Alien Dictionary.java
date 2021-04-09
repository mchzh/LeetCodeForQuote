class Solution {
    // create dag then topology sort
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";
        Map<Character, Set<Character>> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (String w : words) {
            for (char c : w.toCharArray()) set.add(c);
        }
        int[] indegree = new int[26];
        for (int i = 0; i < words.length-1; i++) {
            String s1 = words[i];
            String s2 = words[i+1];
            for (int j = 0; j < s1.length(); j++) {
                if (j >= s2.length()) return "";
                if (s1.charAt(j)  != s2.charAt(j)) { // first different place will exit
                    if (map.containsKey(s1.charAt(j)) && map.get(s1.charAt(j)).contains(s2.charAt(j))) break;
                    map.computeIfAbsent(s1.charAt(j), k-> new HashSet<>()).add(s2.charAt(j));
                    indegree[s2.charAt(j)-'a']++;
                    break;
                }
            }
        }
        
        // topology sort(BFS)
        Queue<Character> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : set) {
            if (set.contains(c) && indegree[c-'a'] == 0)  {
                sb.append(c);
                q.offer(c);
            }
        }
        
        while (!q.isEmpty()) {
            char c = q.poll();
            if (!map.containsKey(c)) continue;
            for (char next : map.get(c)) {
                indegree[next-'a']--;
                if (set.contains(next) && indegree[next-'a'] == 0) {
                    sb.append(next);
                    q.offer(next);
                }
            }
        }
        
        return sb.length() == set.size() ? sb.toString() : "";
    }
}
