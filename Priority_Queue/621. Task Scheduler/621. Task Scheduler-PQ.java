class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char c : tasks) count[c-'A']++;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>( (a, b) -> (b-a));
        for (int c : count) {
            if (c != 0) pq.offer(c);
        }
        
        n++;
        int rets = 0;
        while (!pq.isEmpty()) {
            int k = Math.min(n, pq.size());
            List<Integer> temp = new ArrayList<>();
            for (int i=0; i < k;i++) {
                int cur = pq.poll();
                cur--;
                if (cur > 0) temp.add(cur); // for next cycle
            }
            
            if (temp.size() == 0) {
                rets += k;
            } else {
                rets += n;
                for (int t : temp) pq.offer(t);
            }
            
        }
        
        return rets;
    }
}

// t: {5a 2b 1c} n = 2
// 1r-> t: {4a 1b 1c} n = 2
// 2r-> t: {3a 1c} n = 2
// 3r-> t: {2a} n = 2
// 4r-> t: {1a} n = 2
// 5r-> t: {} n = 2
// ababacaIaI
