class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> freepq = new PriorityQueue<>((a, b) -> (b-a));
        int n = profits.length;
        int[][] busy = new int[n][2];

        for (int i = 0; i < profits.length; i++) {
            busy[i][0] = capital[i];
            busy[i][1] = profits[i];
        }
        Arrays.sort(busy, (a,b) ->(a[0]-b[0]));

        int rets = w;
        int loop = Math.min(k, n);
        int idx = 0;
        for (int i = 0; i < loop; i++) {
            while (idx < n && busy[idx][0] <= rets) {
                freepq.offer(busy[idx][1]);
                idx++;
            }
            if (freepq.isEmpty())  break;
            rets += freepq.poll();
        }
        return rets;
    }
}
// [w, c]
// freeBQ
// busyBQ
