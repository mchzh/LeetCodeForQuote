class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> rets = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(candidates, target, 0, rets, list, 0);
        return rets;
    }
    private void dfs(int[] candidates, int target, int sum, List<List<Integer>> rets, List<Integer> list, int pos) {
        if (sum > target) return;
        if (sum == target) {
            rets.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = pos; i < candidates.length; i++) {
            // remove the duplicate element
            // later one cannot retrive if previous same element not be selected
            if (i > pos && candidates[i-1] == candidates[i]) continue;
            list.add(candidates[i]);
            dfs(candidates, target, sum+candidates[i], rets, list, i+1);
            list.remove(list.size()-1);
        }
    }
}

// t = 8
// 4 [3, 3, 2, 1, 1, 1]
// 3 [3, 3, 2, 1, 1, 1]

// for (int i = idx; i < candidates.size(); i++) {
//     if (i > idx && candidates[i] == candidates[i-1]) 
//         continue;
// }
