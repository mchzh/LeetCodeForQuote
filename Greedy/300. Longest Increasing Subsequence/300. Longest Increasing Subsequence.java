class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // LIS
        List<Integer> lisQueue = new ArrayList<>();
        for (int l : nums) {
            if (lisQueue.size() == 0 || l > lisQueue.get(lisQueue.size()-1)) {
                lisQueue.add(l);
            } else {
                // get insert pos then update
                int pos = Collections.binarySearch(lisQueue, l);
                if (pos < 0) {
                    lisQueue.set(-pos-1, l);
                }
            }
        }
        return lisQueue.size();
    }
}
