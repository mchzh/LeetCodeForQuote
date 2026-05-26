class Solution {
    // double point
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> val2count = new HashMap<>();
        int pair = 0;
        long rets = 0;
        int left = 0;
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            val2count.put(cur, val2count.getOrDefault(cur, 0)+1);
            pair += val2count.get(cur)-1;
            
            while (left < i && pair >= k) {
                int reduce = nums[left];
                pair -= val2count.get(reduce)-1;
                val2count.put(reduce, val2count.getOrDefault(reduce, 0)-1); // move left and update map count
                left++;
            }
            
            rets += (long)left;
        }
        return rets;
    }
}
// X X X X X X 
//     i ... j
// not good
// for all i` < i is good:
// res += (0,1,2,....,i-1) (i-0)
// slide window reduce and extend condition:
// i...j pair more than k to left++ untill window pair < k
