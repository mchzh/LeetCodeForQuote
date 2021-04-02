class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        List<Integer> rets = new ArrayList<>();
        for (int l : nums) {
            if (rets.size() == 0 || l > rets.get(rets.size()-1)) {
                rets.add(l);
            } else {
                int pos = Collections.binarySearch(rets, l);
                if (pos < 0) rets.set(-1*(pos+1), l);
            }
        }
        return rets.size();
    }
}
