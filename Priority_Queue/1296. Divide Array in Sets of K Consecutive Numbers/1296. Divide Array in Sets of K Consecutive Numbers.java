class Solution {
    // https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/discuss/457687/Java-Map-and-PriorityQueue-O(dlgd)
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        if (n % k != 0) return false;
        // map record the freq
        Map<Integer, Integer> map = new HashMap<>();
        for (int c : nums) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int key : map.keySet()) {
            pq.add(key);
        }
        
        while (!pq.isEmpty()) {
            // start point
            int cur = pq.poll();
            if (map.get(cur) == 0) continue;
            int times = map.get(cur);
            for (int i = 0; i < k; i++) {
                if (!map.containsKey(cur+i) || map.get(cur+i) < times) return false;
                map.put(cur+i, map.get(cur+i)-times);
            }
            n -= k*times;
        }
        return n == 0;
    }
}

// random composite
// -------
//    ------
//         ------
// handle overlap
