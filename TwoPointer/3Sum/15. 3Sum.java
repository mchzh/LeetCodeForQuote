class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rets = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        
        for (int i = 0; i < n; i++) {
            int target = -nums[i];
            // two sum
            int left = i+1, right = n-1;
            while (left < right) {
                int cur = nums[left] + nums[right];
                int curl = left, curr = right;
                if (cur == target) {
                    rets.add(Arrays.asList(nums[i], nums[curl], nums[curr]));
                    left++;
                    right--;
                } else if (cur > target) {
                    right--;
                } else {
                    left++;
                }
                while (left != curl && left < right && nums[left] == nums[curl]) left++;
                while (right != curr && left < right && nums[right] == nums[curr]) right--;
            }
            
            int j = i;
            while (j < n && nums[j] == nums[i]) j++;
            i = j-1;
        }
        
        return rets;
    }
}
