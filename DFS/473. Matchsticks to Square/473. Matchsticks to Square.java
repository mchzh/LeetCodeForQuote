class Solution {
    int K = 4;
    public boolean makesquare(int[] nums) {
        if ( nums == null || nums.length == 0 ) return false;
        int sum = 0;
        Arrays.sort(nums);
        reverse(nums);
        for (int num : nums) {
            sum += num;
        }
        if (sum%K != 0) return false;
        sum /= K;
        
        int[] visited = new int[nums.length];
        return helper(nums, visited, 0, 0, 0, sum);
    }
    
    private boolean helper(int[] nums, int[] visited, int curPos, int curGroup, int curSum, int sum) {
        if (curGroup == K) return true;
        if (curSum == sum) return helper(nums, visited, 0, curGroup+1, 0, sum);
        if (curSum > sum) return false;
        if (curPos == nums.length) return false;
        
        for (int i = curPos; i < nums.length; i++) {
            if (visited[i]  == 1) continue;
            if (i >= 1 && visited[i-1] == 0 && nums[i] == nums[i-1]) continue;
            
            visited[i] = 1;
            if (helper(nums, visited, curPos+1, curGroup, curSum+nums[i], sum)) return true;
            visited[i] = 0;
        }
        return false;
    }
    
    private void reverse(int[] input) { 
        int last = input.length - 1; 
        int middle = input.length / 2; 
        for (int i = 0; i <= middle; i++) { 
            int temp = input[i]; 
            input[i] = input[last - i]; 
            input[last - i] = temp; 
        } 
    }
}
