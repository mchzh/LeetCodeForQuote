class Solution {
    // creat graph and dfs get path sum
    int rets = 0;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            if (manager[i] != -1) {
                map.computeIfAbsent(manager[i], k -> new ArrayList<>()).add(i);
            }
        }
        dfs(map, headID, 0, informTime);
        return rets;
    }
    private void dfs(Map<Integer, List<Integer>> map, int pos, int time, int[] informTime) {
        if (!map.containsKey(pos)) {
            rets = Math.max(rets, time);
            return;
        }
        
        int nexttime = time+informTime[pos];
        for (int next : map.get(pos)) {
            dfs(map, next, nexttime, informTime);
        }
    }
}
