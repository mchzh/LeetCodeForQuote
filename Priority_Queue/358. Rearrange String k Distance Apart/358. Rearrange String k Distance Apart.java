class Solution {
    // https://leetcode.com/problems/rearrange-string-k-distance-apart/discuss/83192/Java-7-version-of-PriorityQueue-O(nlogn)-with-comments-and-explanations
    public String rearrangeString(String s, int k) {
        if (s == null || s.length() == 0) return s;
        if (k == 0) return s;
        // pq + map
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c-'a']++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0] == b[0] ? a[1]-b[1] : b[0]-a[0]));
        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) continue;
            pq.offer(new int[] {count[i], i});
        }
        
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            if (pq.size() < k && pq.peek()[0] > 1) return "";
            
            // get k num
            int cur = Math.min(k, pq.size());
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < cur; i++) {
                int[] node = pq.poll();
                sb.append((char)('a' + node[1]));
                list.add(node);
            }
            for (int[] l : list) {
                if (l[0] >1) pq.offer(new int[] {l[0]-1, l[1]});
            }
        }
        return sb.toString();
    }
}

// a a b b c c 3 similar task scheduler
// aaaaaaa
// bbbbb
// cccc
// ddd
// e
// f

// aaaaaa
// bbbb
// f
