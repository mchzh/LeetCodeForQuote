class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        /*[-1,2147483647]
1
21474836478*/ // if int, it will outboundary on doing plus or minus
        // treeset or buckets
        TreeSet<Long> slideWindow = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long n = (long)nums[i];
            //System.out.println(n);
            Long cei = slideWindow.ceiling(n);
            if (cei != null && cei-n <= (long)t) return true;
            
            // find the preccessor
            Long flo = slideWindow.floor(n);
            if (flo != null && n-flo <= (long)t) return true;
            
            slideWindow.add(n);
            //System.out.println("add element -> " + n);
            if (slideWindow.size() > k) slideWindow.remove((long)nums[i-k]);
        }
        return false;
    }
}
