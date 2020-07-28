class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        int max = 0;
        for (int i  = 0; i < nums.length; i++) {
            sum += nums[i];

            if (map.containsKey(sum-k)) {
                max = Math.max(max, i-map.get(sum-k));
            }
            
            if (map.containsKey(sum)) continue;
            map.put(sum, i); //update the index for sum which never existed

        }
        return max;

    }
}
