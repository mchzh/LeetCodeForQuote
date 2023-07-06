class Solution {
    // https://github.com/wisdompeak/LeetCode/blob/master/Greedy/2233.Maximum-Product-After-K-Increments/2233.Maximum-Product-After-K-Increments.cpp
    // greedy + binary search
    public int maximumProduct(int[] nums, int k) {
        Arrays.sort(nums);
        long mod = (long)(1e9 + 7);
        int n = nums.length;
        long[] presum = new long[n+1];
        // diff[i] : = nums[i] * (i+1) - presum[i+1]
        for (int i = 0; i < n; i++) {
            presum[i+1] = presum[i] + nums[i];
        }

        long[] diff = new long[n];
        for (int i = 0; i < n; i++) {
            diff[i] = (long)nums[i] * (long)(i+1) - presum[i+1];
            //System.out.println(i + " " + nums[i] + " " + presum[i+1] + " " + diff[i]);
        }
        // binary search to find the last item diff[p] <= k
        // diff[p+1] > k
        int left = 0, right = n-1;
        while (left < right) {
            int mid = right - (right - left)/2;
            //if (diff[mid] < 0) System.out.println(mid + " " + diff[mid]);
            
            if (diff[mid] <= (long)k) {
                //System.out.println("left part -> " + left + " " + diff[left] + " " + right + " " + mid + " " + k + " " + (diff[left] <= k));
                left = mid;
            } else {
                //System.out.println("right part -> " + left + " " + diff[left] + " " + right + " " + mid + " " + k + " " + (diff[left] <= k));
                right = mid - 1;
            }
            //System.out.println(left + " " + diff[left] + " " + right + " " + mid + " " + k + " " + (diff[left] <= k)); 
        }
        //System.out.println(left + " " + diff[left] + " " + right);

        // diff[left]
        // k - nums[left]*(left + 1) is the extra one plus
        
        long rets = 1;
        long each = (presum[left+1]+k)/(left+1); // lift level
        long extra = (presum[left+1]+k)%(left+1); // all left number will lift together
        //System.out.println(extra + " " + (presum[left+1]+k)%(left+1));
        for (int i = 0; i < extra; i++) {
            rets = (rets * (long)(each + 1)) % mod;
            
        }
        for (int i = (int)extra; i < left + 1; i++) {
            rets = (rets * (long)(each)) % mod;
        }
        for (int i = left+1; i < n; i++) {
            rets = (rets*(long)(nums[i])) % mod;
        }

        return (int)rets;
    }
}
