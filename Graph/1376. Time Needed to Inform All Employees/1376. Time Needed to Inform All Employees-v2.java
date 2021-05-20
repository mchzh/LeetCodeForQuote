class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int rets = 0;
        for (int i = 0; i < n; i++) {
            rets = Math.max(rets, dfs(i, manager, informTime));
        }
        return rets;
    }
    private int dfs(int pos, int[] manager, int[] informTime) {
        if (manager[pos] != -1) {
            informTime[pos] += dfs(manager[pos], manager, informTime);
            manager[pos] = -1;
        }
        return informTime[pos];
    }
}
