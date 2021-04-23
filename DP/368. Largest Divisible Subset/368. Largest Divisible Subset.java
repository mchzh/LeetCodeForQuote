class Solution {
    // sort
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(prev, -1);
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] != 0) continue;
                if (dp[i] >= dp[j]+1) continue;
                dp[i] = dp[j]+1;
                prev[i] = j;
            }
        }
        int idx = 0;
        int rets = 0;
        for (int i = 0; i < n; i++) {
            if (rets >= dp[i]) continue;
            rets = dp[i];
            idx = i;
        }
        List<Integer> list = new ArrayList<>();
        while (idx != -1) {
            list.add(nums[idx]);
            idx = prev[idx];
        }
        return list;
    }
}
