class Solution {
    // bfs
    // https://github.com/doocs/leetcode/blob/main/solution/3600-3699/3666.Minimum%20Operations%20to%20Equalize%20Binary%20String/README.md
    public int minOperations(String s, int k) {
        int n = s.length();
        TreeSet<Integer>[] ts = new TreeSet[2];
        //Arrays.setAll(ts, i -> new TreeSet<>());
        ts[0] = new TreeSet<>();
        ts[1] = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            ts[i%2].add(i);
        }
        int init = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') init++;
        }

        int ans = 0;
        Deque<Integer> q = new ArrayDeque<>();
        ts[init%2].remove(init);
        q.offer(init);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (cur == 0) return ans;

                // next state
                int lnode = cur+k-2*Math.min(cur, k);
                int rnode = cur+k-2*Math.max(0, k-n+cur);
                int parity = lnode%2;
                // offer valid state to queue and at the same time to remove it from ordered set
                Integer next = ts[parity].ceiling(lnode);
                while (next != null && next <= rnode) {
                    q.offer(next);
                    ts[parity].remove(next);
                    next = ts[parity].ceiling(lnode);
                }
            }
            ans++;
        }
        return -1;
    }
}
// loop all min to max will tle
// and use the two visited order set to make improvement
// m : 0
// n-m : 1
// next max: min(m, k)
// max 1: 
// select x zero:
// 0 <= x <= min(m, k)
// k-x one: k-x <= n-m => x >= k-n+m
// both: k-n+m <= x <= min(m,k)
// [max(0, k-n+m), min(m, k)]
// select x zero will change as x one and (k-x) zero
// next zero number is : m-x + (k-x) = m+k-2x (x in [max(0, k-n+m), min(m, k)])
// lnode = m+k-2*(min(m, k))
// rnode = m+k-2*(max(0, k-n+m))
