class Solution {
    int K;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // sort array then dfs
        if (nums == null || nums.length == 0) return false;
        
        Arrays.sort(nums);
        int[] rnums = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            rnums[nums.length-1-i] = nums[i];
        }
        if ( sum%k != 0 ) return false;
        sum /= k;
        
        int[] visited = new int[nums.length];
        K = k;
        return helper(rnums, visited, 0, 0, 0, sum);
    }
    private boolean helper(int[] rnums, int[] visited, int pos, int curGroup, int curSum, int tar) {
        if (curGroup == K) return true;
        
        if (curSum == tar) return helper(rnums, visited, 0, curGroup+1, 0, tar);
        if (curSum > tar) return false;
        if (pos == rnums.length) return false;
        
        
        
        for (int i = pos; i < rnums.length; i++) {
            if (visited[i] == 1) continue;
            if (i>=1 && rnums[i] == rnums[i-1] && visited[i-1] == 0) continue;
            
            visited[i] = 1;
            if ( helper(rnums, visited, i+1, curGroup, curSum+rnums[i], tar) ) return true;
            visited[i] = 0;
        }
        return false;
    }
}
