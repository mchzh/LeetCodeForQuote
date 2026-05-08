class Solution {
    // bfs
    public int minJumps(int[] nums) {
        int maxval = 0;
        for (int v : nums) maxval = Math.max(maxval, v);
        int[] spf = new int[maxval+1];
        for (int i = 2; i <= maxval; i++) {
            if (spf[i] != 0) continue;
            // no spf, to compute it with val
            // == 0 is prime
            for (int j = i; j <= maxval; j += i) {
                spf[j] = i; // all multip of i is i
            }
        }

        int n = nums.length;
        Map<Integer, List<Integer>> prime_to_idx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            while (x > 1) {
                int p = spf[x];
                prime_to_idx.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
                while (x%p == 0) x /= p; 
            }
        }


        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int[] used_prime = new int[maxval+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        dist[0] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == n-1) return dist[cur];

            // next i-1
            if (cur-1 >= 0 && dist[cur-1] == Integer.MAX_VALUE) {
                queue.offer(cur-1);
                dist[cur-1] = dist[cur] + 1;
            }
            // next i-1
            if (cur+1 < n && dist[cur+1] == Integer.MAX_VALUE) {
                queue.offer(cur+1);
                dist[cur+1] = dist[cur] + 1;
            }
            // prime dist
            int x = nums[cur];
            if (x > 1 && spf[x] == x) { // is prime
                // visited;
                if (used_prime[x] == 1) continue;
                used_prime[x] = 1;
                for (int j : prime_to_idx.get(spf[x])) {
                    if (dist[j] == Integer.MAX_VALUE) {
                        queue.offer(j);
                        dist[j] = dist[cur] + 1;
                    }
                }
            }
        }

        return 0;
    }
}

// X X X X X X
//     i
// queue offer cur idx;
// next idx: idx-1 or idx+1, just visit once
// prime dist
// pre-compute prime condition
// spf[i] = p
// smallest prime factor for cur value
