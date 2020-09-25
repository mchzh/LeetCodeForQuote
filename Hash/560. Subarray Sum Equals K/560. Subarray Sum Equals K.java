class Solution {
    // all positive number should be use two pointer
    // if it exists negative number should be use hash+  prefix array
    public int subarraySum(int[] nums, int k) {
        int ret = 0;
        Map<Integer, Integer> map = new HashMap<>(); // key(sum) -> count;
        map.put(0, 1);
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (map.containsKey(preSum-k)) {
                ret += map.get(preSum-k);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return ret;
    }
}

// X X X X X X X] X X

// sum[i...j] = sum[1..j] - sum[1...i] => sum[1...i] == sum[1...j] - k
//                                          prefixSum
