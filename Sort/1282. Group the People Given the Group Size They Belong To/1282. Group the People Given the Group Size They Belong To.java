class Solution {
    // bucket sort
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;
        List<Integer>[] buckets = new ArrayList[n+1];
        List<List<Integer>> rets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (buckets[groupSizes[i]] == null) buckets[groupSizes[i]] = new ArrayList<>();
            List<Integer> list = buckets[groupSizes[i]];
            list.add(i);
            if (list.size() == groupSizes[i]) {
                rets.add(new ArrayList<Integer>(list));
                list.clear();
            }
        }
        
//         List<List<Integer>> rets = new ArrayList<>();
//         for (int i = 1; i <= n; i++) {
//             if (buckets[i] == null || buckets[i].size() == 0) continue;
//             List<Integer> curBuc = buckets[i];
            
//             int size = curBuc.size();
//             int idx = 0;
//             List<Integer> temp = new ArrayList<>();
//             while (idx < size) {
//                 temp.add(curBuc.get(idx));
//                 if ((idx+1)%i == 0) {
//                     rets.add(new ArrayList<Integer>(temp));
//                     temp.clear();
//                 }
//                 idx++;
//             }
//         }
        return rets;
    }
}
