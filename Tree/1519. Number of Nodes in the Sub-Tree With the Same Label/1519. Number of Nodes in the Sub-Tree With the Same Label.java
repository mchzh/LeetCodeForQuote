class Solution {
    // https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/discuss/743133/JavaPython-3-DFS-w-brief-explanation-and-analysis.
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        // build undirected graph +DFS
        // build graph
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        
        Set<Integer> visited = new HashSet<>();
        int[] ret = new int[n];
        helper(map, 0, ret, visited, labels);
        return ret;
    }
    private int[] helper(Map<Integer, List<Integer>> map, int pos, int[] ret, Set<Integer> visited, String labels) {
        int[] cnt = new int[26];
        if (visited.add(pos)) {
            char c = labels.charAt(pos);
            for (int next : map.getOrDefault(pos, Collections.emptyList())) {
                int[] sub = helper(map, next, ret, visited, labels);
                for (int i = 0; i < cnt.length; i++) {
                    cnt[i] += sub[i];
                }
            }
            cnt[c-'a']++;
            ret[pos] = cnt[c-'a'];
        }
        
        return cnt;
    }
}
