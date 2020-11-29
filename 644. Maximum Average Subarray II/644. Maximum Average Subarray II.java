class Solution {
    // binary search + two pointer
    public double findMaxAverage(int[] nums, int k) {
//         int n = nums.length;
//         int[] presum = new int[n+1];
//         for (int i = 1; i <= n; i++) {
//             presum[i] = presum[i-1] + nums[i-1];
//         }
        
//         double rets = Integer.MIN_VALUE*1.0;
//         for (int i = k; i <= n; i++) {
//             for (int j = 0; j <= i-k; j++) {
//                 double average = (presum[i]-presum[j])*1.0/(i-j);
//                 //System.out.println(average);
//                 rets = Math.max(rets, average);
//             }
//         }
//         return rets;
        double max_val = Integer.MIN_VALUE;
        double min_val = Integer.MAX_VALUE;
        // get current max and min
        for (int num : nums) {
            max_val = Math.max(num, max_val);
            min_val = Math.min(num, min_val);
        }
        
        double error = Integer.MAX_VALUE, pre_mid = max_val;
        while (error > 0.00001) {
            double mid = (max_val + min_val) * 0.5;
            if (check(nums, mid, k)) {
                min_val = mid;
            } else {
                max_val = mid;
            }
            error = Math.abs(pre_mid - mid); // scope
            pre_mid = mid;
        }
        return min_val;
    }
    public boolean check(int[] nums, double mid, int k) {
        // sum and pre_sum, min_sum
        // first k then more k
        // a1 + a2 + .... aj >= j*mid and j >= k;
        double sum = 0, presum = 0, minsum = 0;
        
        for (int i = 0; i< k; i++) {
            sum += nums[i]-mid;
        }
        if (sum >= 0) return true;
        // check any subarray more than k
        // keep a window which the nummber of element more than k
        for (int i = k; i < nums.length;i++) {
            sum += nums[i]-mid;
            presum += nums[i-k] - mid;
            minsum = Math.min(minsum, presum);
            if (sum >= minsum) {
                return true;
            }
        }
        return false;
    }
}
