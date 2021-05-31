class Solution {
    // 1-index
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = candiesCount.length;
        long[] sum = new long[n];
        for (int i = 0;i < n; i++) {
            sum[i] = (i == 0 ? 0 : sum[i-1]) + candiesCount[i];
        }
        int m = queries.length;
        boolean[] rets = new boolean[m];
        for (int i = 0; i < m; i++) {
            int[] q = queries[i];
            if (q[0] == 0) {
                long end = sum[q[0]]-1;
                long start = 0;
                rets[i] = (q[1]>=start && q[1]<=end);
                continue;
            }
            
            // if (i == 0) {
            //     System.out.println(sum[q[0]] + " " + sum[q[0]-1] + " " + q[2] + " " + q[1] + " " + n + " " + candiesCount[85]);
            // }
            long end = sum[q[0]]-1;
            long start = sum[q[0]-1]/q[2];
            rets[i] = (q[1]>=start && q[1]<=end);
        }
        return rets;
    }
}
