class Solution {
    // 494. Target Sum
    // knapsnack coin change
    public int lastStoneWeightII(int[] stones) {
        Set<Integer> set = new HashSet<>();
        set.add(0);
        
        for (int s : stones) {
            Set<Integer> set_temp = new HashSet<>();
            set_temp.addAll(set);
            set.clear();
            for (int k : set_temp) {
                set.add(k+s);
                set.add(k-s);
            }
        }
        int rets = Integer.MAX_VALUE;
        for (int k : set) {
            if (k >= 0 && rets > k) rets = k;
        }
        return rets;
    }
}

//  a b c d ....
// +/-a +/-b +/-c +/-d
