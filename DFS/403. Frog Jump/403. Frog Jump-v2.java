class Solution {
    Set<Integer> set;
    Map<String, Boolean> memo;
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) return false;
        set = new HashSet<>();
        for (int s : stones) {
            set.add(s);
        }
        memo = new HashMap<>();
        // dp or dfs+memo
        return dfs(stones, 0, 0);
    }
    private boolean dfs(int[] stones, int pos, int jump) {
        if (pos == stones[stones.length-1]) return true;
        if (!set.contains(pos)) return false;

        String cur = pos + "#" + jump;
        if (memo.containsKey(cur)) return false;

        if (jump-1 > 0 && dfs(stones, pos+jump-1, jump-1)) return true;
        if (jump > 0 && dfs(stones, pos+jump, jump)) return true;
        if (dfs(stones, pos+jump+1, jump+1)) return true;

        memo.put(cur, false);
        return false;
    }
}
