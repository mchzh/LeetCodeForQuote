class Solution {
    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[n-1]-nums[n-2], 1);
        
        int rets = 0;
        for (int i = n-3; i >= 0; i--) {
            // count the equals pattern num: d-c == a+b
            // a + b => numa[i] + nums[j]
            for (int j = i-1; j >= 0; j--) {
                rets += map.getOrDefault(nums[i] + nums[j], 0);
            }
            
            // store the d-c pattern
            for (int j = n-1; j > i; j--) {
                int cur = nums[j] - nums[i];
                map.put(cur, map.getOrDefault(cur, 0) + 1);
            }
        }
        
        return rets;
    }
}

// two sum theory

// => d-c = a+b
// (d-c) is one element and (a+b) is one element
// with map and from right to left
