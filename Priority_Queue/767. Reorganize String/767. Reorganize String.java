class Solution {
    // priorityqueue
    public String reorganizeString(String S) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>( (a, b) -> (b[1]-a[1]) );
        
        int[] map = new int[256];
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            map[ch]++;
        }
        for (int i = 0; i < 256; i++) {
            if (map[i] == 0) continue;
            pq.offer(new int[] {i, map[i]});
        }
        
        String str = "";
        while (pq.size() > 1) {
            int[] first = pq.poll();
            int[] second = pq.poll();
            str = str + (char)first[0] + (char)second[0];
            if (first[1] > 1) pq.offer(new int[] {first[0], first[1]-1});
            if (second[1] > 1) pq.offer(new int[] {second[0], second[1]-1});
        }
        if (pq.size() == 1) {
            return pq.peek()[1] > 1 ? "" : str+(char)pq.peek()[0];
        } else return str;
    }
}
