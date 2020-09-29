class Solution {
    // memory search
    int[] memo = new int[1001];
    int dis = 0;
    public int maxJumps(int[] arr, int d) {
        int ret = 0;
        dis = d;
        for (int i = 0; i < arr.length; i++) {
            dfs(i, arr);
            ret = Math.max(ret, memo[i]);
        }
        return ret;
    }
    private int dfs(int pos, int[] arr) {
        if (memo[pos] != 0) return memo[pos];
        int ret = 1;
        for (int k = 1; k <= dis; k++) {
            if (pos+k >= arr.length) break;
            // no any data more thant current element
            if (arr[pos+k] >= arr[pos]) break;
            ret = Math.max(ret, dfs(pos+k, arr)+1);
        }
        for (int k = 1; k <= dis; k++) {
            if (pos-k < 0) break;
            // no any data more thant current element
            if (arr[pos-k] >= arr[pos]) break;
            ret = Math.max(ret, dfs(pos-k, arr)+1);
        }
        memo[pos] = ret;
        return ret;
    }
}

//i+x : i-x
