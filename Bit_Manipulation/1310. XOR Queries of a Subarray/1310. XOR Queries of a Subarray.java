class Solution {
    // same as presum
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] prexor = new int[n+1];
        for (int i = 0; i < n; i++) {
            prexor[i+1] = arr[i]^prexor[i];
        }
        int ql = queries.length;
        int[] rets = new int[ql];
        for (int i = 0; i < ql; i++) {
            rets[i] = prexor[queries[i][1]+1]^prexor[queries[i][0]];
        }
        return rets;
    }
}
