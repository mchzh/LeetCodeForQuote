class Solution {
    // consider it with 560
    public boolean checkSubarraySum(int[] nums, int k) {
        // presum + map
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>(); // presum%k -> idx
        
        int sum = 0;
        map.put(0, -1); // virtual node
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (k != 0) sum %= k;
            if (map.containsKey(sum)) {
                if (i-map.get(sum)-1 >=1) return true;
            } else {
                map.put(sum, i);
            }
        }
        
        return false;
    }
}
