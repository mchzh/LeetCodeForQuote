class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] copynums = new int[n+1];
        for (int i = 1; i <= n; i++) {
            copynums[i] = nums[i-1];
        }
        int[] presum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i-1]+copynums[i];
        }
        
        Map<Integer, Integer> map = new HashMap<>(); // presum -> idx;
        map.put(0, 0);
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i-1];
            if (map.containsKey(presum[i]-target)) {
                dp[i] = Math.max(dp[i], dp[map.get(presum[i]-target)]+1);
            }
            map.put(presum[i], i);
        }
        
        return dp[n];
    }
}


// X [X X] X[X X X] X [X X i]
//        j'       j       i 
//                  [j+1... i] = target
// dp[i] : the maximum number of non-empty non-overlapping subarrays such that the sum of values in each subarray is equal to target for the ith position of this array
// dp[i] = dp[i-1]
// dp[i] = max(dp[j] + 1) (sum(j+1 ... i) == target)
// prefix sum -> map  presum[i] - presum[j] -> map (presum -> idx)

//     for (int i = 0; i < n ;i++) {
//         for (int j ) {}
//     }
